package br.com.lucasisrael.jetposemovies.movies.data.datasource.remote

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import br.com.lucasisrael.jetposemovies.movies.data.api.UpcomingMoviesApi
import br.com.lucasisrael.jetposemovies.movies.data.datasource.local.MoviesDataBase
import br.com.lucasisrael.jetposemovies.movies.data.mappers.toMoviesListEntity
import br.com.lucasisrael.jetposemovies.movies.data.mappers.toUpcomingMovieEntity
import br.com.lucasisrael.jetposemovies.movies.data.models.local.PopularWithMovie
import br.com.lucasisrael.jetposemovies.movies.data.models.local.UpcomingWithMovie
import br.com.lucasisrael.jetposemovies.movies.data.models.response.MoviesResponse
import coil.network.HttpException
import java.io.IOException

@OptIn(ExperimentalPagingApi::class)
class UpcomingMoviesRemoteMediator(
    private val dataBase: MoviesDataBase,
    private val api: UpcomingMoviesApi,
) : RemoteMediator<Int, UpcomingWithMovie>() {
    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, UpcomingWithMovie>,
    ): MediatorResult {
        return try {

            val loadKey = getLoadKey(loadType, state)

            if (loadKey == -1) return MediatorResult.Success(endOfPaginationReached = true)

            val movies = fetchMovies(loadKey)

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
        state: PagingState<Int, UpcomingWithMovie>,
    ): Int {
        val loadKey = when (loadType) {
            LoadType.REFRESH -> 1
            LoadType.PREPEND -> -1
            LoadType.APPEND -> {
                val lastItem = state.lastItemOrNull()
                if (lastItem == null) {
                    1
                } else {
                    (lastItem.upcomingMovie.tableId / state.config.pageSize) + 1
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
        val upcomingDao = dataBase.upcomingDao

        dataBase.withTransaction {
            if (loadType == LoadType.REFRESH) {
                upcomingDao.clearAll()
                upcomingDao.clearPrimaryKey()
            }

            val movieEntities = movies.results.map { it.toMoviesListEntity() }
            movieDao.upsert(list = movieEntities)

            val upcomingMovies = movies.results.map { it.toUpcomingMovieEntity() }
            upcomingDao.upsert(upcomingMovies)
        }
    }

}
