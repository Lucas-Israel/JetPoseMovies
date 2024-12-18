package br.com.lucasisrael.jetposemovies.movies.data.datasource.remote

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import br.com.lucasisrael.jetposemovies.movies.data.api.TopRatedApi
import br.com.lucasisrael.jetposemovies.movies.data.datasource.local.MoviesDataBase
import br.com.lucasisrael.jetposemovies.movies.data.mappers.toMoviesListEntity
import br.com.lucasisrael.jetposemovies.movies.data.mappers.toTopRatedMovieEntity
import br.com.lucasisrael.jetposemovies.movies.data.models.local.TopRatedWithMovie
import br.com.lucasisrael.jetposemovies.movies.data.models.response.MoviesResponse
import coil.network.HttpException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.IOException

import javax.inject.Inject

@OptIn(ExperimentalPagingApi::class)
class TopRatedRemoteMediator @Inject constructor(
    private val dataBase: MoviesDataBase,
    private val api: TopRatedApi,
) : RemoteMediator<Int, TopRatedWithMovie>() {
    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, TopRatedWithMovie>,
    ): MediatorResult {
        return withContext(Dispatchers.Default) {
            try {

                val loadKey = getLoadKey(loadType, state)

                val movies = fetchMovies(loadKey)

                moviesDataBaseTransaction(loadType, movies)

                MediatorResult.Success(endOfPaginationReached = movies.page > 500)

            } catch (e: IOException) {
                MediatorResult.Error(e)
            } catch (e: HttpException) {
                MediatorResult.Error(e)
            }
        }
    }

    private suspend fun fetchMovies(page: Int): MoviesResponse {
        return api.fetch(page = page)
    }

    private suspend fun moviesDataBaseTransaction(
        loadType: LoadType,
        movies: MoviesResponse,
    ) {
        val movieDao = dataBase.movieDao
        val topRatedDao = dataBase.topRatedDao

        dataBase.withTransaction {
            if (loadType == LoadType.REFRESH) {
                movieDao.clearAll()
                topRatedDao.clearAll()
            }

            val movieEntities = movies.results.map { it.toMoviesListEntity() }
            movieDao.upsert(list = movieEntities)

            val topRatedEntities = movies.results.map { it.toTopRatedMovieEntity() }
            topRatedDao.upsert(topRatedEntities)
        }
    }

    private fun getLoadKey(
        loadType: LoadType,
        state: PagingState<Int, TopRatedWithMovie>,
    ): Int {
        val loadKey = when (loadType) {
            LoadType.REFRESH -> {
                1
            }

            LoadType.PREPEND -> {
                MediatorResult.Success(endOfPaginationReached = true)
                1
            }

            LoadType.APPEND -> {
                val lastItem = state.lastItemOrNull()
                if (lastItem == null) {
                    1
                } else {
                    1
                }
            }
        }
        return loadKey
    }
}