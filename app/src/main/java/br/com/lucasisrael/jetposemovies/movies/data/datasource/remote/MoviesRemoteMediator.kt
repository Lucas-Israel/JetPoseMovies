package br.com.lucasisrael.jetposemovies.movies.data.datasource.remote

import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import br.com.lucasisrael.jetposemovies.movies.data.api.MoviesApi
import br.com.lucasisrael.jetposemovies.movies.data.datasource.local.MovieDao
import br.com.lucasisrael.jetposemovies.movies.models.local.MovieGenreIdsWithMovie
import br.com.lucasisrael.jetposemovies.movies.models.response.MoviesResponse
import coil.network.HttpException
import java.io.IOException

@OptIn(ExperimentalPagingApi::class)
class MoviesRemoteMediator(
    private val dao: MovieDao,
    private val api: MoviesApi,
) : RemoteMediator<Int, MovieGenreIdsWithMovie>() {

    var genreId: Int = 0

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, MovieGenreIdsWithMovie>,
    ): MediatorResult {
        return try {

            val loadKey = getLoadKey(loadType = loadType, state = state)

            if (loadKey == -1) return MediatorResult.Success(endOfPaginationReached = true)

            val movies = fetchMovies(genreId = genreId, page = loadKey)

            saveToDatabase(loadType = loadType, movies = movies)

            MediatorResult.Success(endOfPaginationReached = movies.results.isEmpty())
        } catch (e: IOException) {
            MediatorResult.Error(e)
        } catch (e: HttpException) {
            MediatorResult.Error(e)
        }
    }

    private fun getCount(): Int {
        return dao.getCount(genreId = genreId)
    }

    private fun getLoadKey(
        loadType: LoadType,
        state: PagingState<Int, MovieGenreIdsWithMovie>,
    ): Int {
        val loadKey = when (loadType) {
            LoadType.REFRESH -> 1
            LoadType.PREPEND -> -1
            LoadType.APPEND -> {
                val lastItem = state.lastItemOrNull()
                if (lastItem == null) {
                    1
                } else {
                    getCount() / state.config.pageSize + 1
                }
            }
        }
        return loadKey
    }

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    private suspend fun fetchMovies(genreId: Int, page: Int): MoviesResponse {
        return api.fetch(genreId = genreId, page = page)
    }

    private fun saveToDatabase(
        loadType: LoadType,
        movies: MoviesResponse,
    ) {

        if (loadType == LoadType.REFRESH) {
            dao.clearAll()
        }

        dao.upsert(list = movies.results)
    }
}
