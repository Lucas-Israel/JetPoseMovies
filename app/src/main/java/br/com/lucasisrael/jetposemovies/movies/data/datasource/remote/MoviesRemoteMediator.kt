package br.com.lucasisrael.jetposemovies.movies.data.datasource.remote

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import br.com.lucasisrael.jetposemovies.movies.data.api.MoviesApi
import br.com.lucasisrael.jetposemovies.movies.data.datasource.local.MoviesDataBase
import br.com.lucasisrael.jetposemovies.movies.data.mappers.toMoviesListEntity
import br.com.lucasisrael.jetposemovies.movies.data.models.local.MovieEntity
import br.com.lucasisrael.jetposemovies.movies.data.models.response.MoviesResponse
import coil.network.HttpException
import java.io.IOException

@OptIn(ExperimentalPagingApi::class)
class MoviesRemoteMediator(
    private val moviesDataBase: MoviesDataBase,
    private val api: MoviesApi,
) : RemoteMediator<Int, MovieEntity>() {

    lateinit var genreId: String

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, MovieEntity>,
    ): MediatorResult {
        return try {

            val loadKey = getLoadKey(loadType, state)

            if (loadKey == -1) return MediatorResult.Success(endOfPaginationReached = true)

            val movies = fetchMovies(genreId = genreId, page = loadKey)

            moviesDataBaseTransaction(loadType = loadType, movies = movies)

            MediatorResult.Success(endOfPaginationReached = loadKey >= movies.totalPages)

        } catch (e: IOException) {
            MediatorResult.Error(e)
        } catch (e: HttpException) {
            MediatorResult.Error(e)
        }
    }

    private fun getLoadKey(
        loadType: LoadType,
        state: PagingState<Int, MovieEntity>,
    ): Int {
        val loadKey = when (loadType) {
            LoadType.REFRESH -> 1
            LoadType.PREPEND -> -1
            LoadType.APPEND -> {
                val lastItem = state.lastItemOrNull()
                if (lastItem == null) {
                    1
                } else {
                    (state.pages.lastIndex / state.config.pageSize) + 1
                    TODO("LOGIC FOR PAGINATION IN THE MOVIES BY GENRE")
                }
            }
        }
        return loadKey
    }

    private suspend fun fetchMovies(genreId: String, page: Int): MoviesResponse {
        return api.fetch(genreId = genreId, page = page)
    }

    private suspend fun moviesDataBaseTransaction(
        loadType: LoadType,
        movies: MoviesResponse,
    ) {
        val dao = moviesDataBase.movieDao

        moviesDataBase.withTransaction {
            if (loadType == LoadType.REFRESH) {
                dao.clearAll()
            }

            val movieEntities = movies.results.map { it.toMoviesListEntity() }
            dao.upsert(list = movieEntities)
        }
    }
}
