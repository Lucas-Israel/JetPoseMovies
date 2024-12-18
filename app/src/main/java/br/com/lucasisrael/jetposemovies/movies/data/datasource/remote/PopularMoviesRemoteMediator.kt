package br.com.lucasisrael.jetposemovies.movies.data.datasource.remote

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import br.com.lucasisrael.jetposemovies.movies.data.api.PopularMoviesApi
import br.com.lucasisrael.jetposemovies.movies.data.datasource.local.MoviesDataBase
import br.com.lucasisrael.jetposemovies.movies.data.mappers.toMoviesListEntity
import br.com.lucasisrael.jetposemovies.movies.data.mappers.toPopularMovieEntity
import br.com.lucasisrael.jetposemovies.movies.data.models.local.PopularWithMovie
import br.com.lucasisrael.jetposemovies.movies.data.models.response.MoviesResponse
import coil.network.HttpException
import java.io.IOException
import javax.inject.Inject

@OptIn(ExperimentalPagingApi::class)
class PopularMoviesRemoteMediator @Inject constructor(
    private val dataBase: MoviesDataBase,
    private val api: PopularMoviesApi,
) : RemoteMediator<Int, PopularWithMovie>() {
    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, PopularWithMovie>,
    ): MediatorResult {
        return try {

            val loadKey = getLoadKey(loadType, state)

            if (loadKey == -1) return MediatorResult.Success(endOfPaginationReached = true)

            val movies = fetchMovies(page = loadKey)

            moviesDataBaseTransaction(loadType, movies)

            MediatorResult.Success(endOfPaginationReached = loadKey >= movies.totalPages)

        } catch (e: IOException) {
            MediatorResult.Error(e)
        } catch (e: HttpException) {
            MediatorResult.Error(e)
        }

    }

    private fun getLoadKey(
        loadType: LoadType,
        state: PagingState<Int, PopularWithMovie>,
    ): Int {
        val loadKey = when (loadType) {
            LoadType.REFRESH -> 1
            LoadType.PREPEND -> -1
            LoadType.APPEND -> {
                val lastItem = state.lastItemOrNull()
                if (lastItem == null) {
                    1
                } else {
                    (lastItem.popularMovie.tableId / state.config.pageSize) + 1
                }
            }
        }
        return loadKey
    }

    private suspend fun fetchMovies(page: Int): MoviesResponse {
        return api.fetch(page = page)
    }

    private suspend fun moviesDataBaseTransaction(
        loadType: LoadType,
        movies: MoviesResponse,
    ) {
        val movieDao = dataBase.movieDao
        val popularDao = dataBase.popularDao

        dataBase.withTransaction {
            if (loadType == LoadType.REFRESH) {
                popularDao.clearAll()
                popularDao.clearPrimaryKey()
            }

            val movieEntities = movies.results.map { it.toMoviesListEntity() }
            movieDao.upsert(list = movieEntities)

            val popularEntity = movies.results.map { it.toPopularMovieEntity() }
            popularDao.upsert(popularEntity)
        }
    }
}
