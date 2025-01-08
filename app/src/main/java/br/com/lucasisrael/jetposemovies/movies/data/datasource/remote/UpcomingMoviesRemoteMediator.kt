package br.com.lucasisrael.jetposemovies.movies.data.datasource.remote

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import br.com.lucasisrael.jetposemovies.movies.data.api.UpcomingMoviesApi
import br.com.lucasisrael.jetposemovies.movies.data.datasource.local.UpcomingMoviesDao
import br.com.lucasisrael.jetposemovies.movies.models.local.UpcomingWithMovie
import br.com.lucasisrael.jetposemovies.movies.models.response.MoviesResponse
import coil.network.HttpException
import java.io.IOException

@OptIn(ExperimentalPagingApi::class)
class UpcomingMoviesRemoteMediator(
    private val dao: UpcomingMoviesDao,
    private val api: UpcomingMoviesApi,
) : RemoteMediator<Int, UpcomingWithMovie>() {

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, UpcomingWithMovie>,
    ): MediatorResult {
        return try {

            val loadKey = getLoadKey(loadType = loadType, state = state)

            if (loadKey == -1) return MediatorResult.Success(endOfPaginationReached = true)

            val movies = fetchMovies(page = loadKey)

            saveToDatabase(loadType = loadType, movies = movies)

            MediatorResult.Success(endOfPaginationReached = movies.results.isEmpty())

        } catch (e: IOException) {
            MediatorResult.Error(e)
        } catch (e: HttpException) {
            MediatorResult.Error(e)
        }
    }

    private fun getCount() = dao.getCount()

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
                    (getCount() / state.config.pageSize) + 1
                }
            }
        }
        return loadKey
    }

    private suspend fun fetchMovies(page: Int): MoviesResponse {
        return api.fetch(page = page)
    }

    private fun saveToDatabase(
        loadType: LoadType,
        movies: MoviesResponse,
    ) {
        if (loadType == LoadType.REFRESH) {
            dao.clearAll()
        }

        dao.upsert(movies.results)
    }
}
