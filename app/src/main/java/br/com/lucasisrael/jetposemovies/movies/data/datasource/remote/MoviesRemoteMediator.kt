package br.com.lucasisrael.jetposemovies.movies.data.datasource.remote

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import br.com.lucasisrael.jetposemovies.common.utils.types.SearchType
import br.com.lucasisrael.jetposemovies.movies.data.api.MoviesApi
import br.com.lucasisrael.jetposemovies.movies.data.datasource.local.MoviesDataBase
import br.com.lucasisrael.jetposemovies.movies.data.mappers.toMoviesListEntity
import br.com.lucasisrael.jetposemovies.movies.data.models.local.MovieEntity
import br.com.lucasisrael.jetposemovies.movies.data.models.response.MoviesResponse
import coil.network.HttpException
import java.io.IOException

@OptIn(ExperimentalPagingApi::class)
class MoviesRemoteMediator(
    private val movieDataBase: MoviesDataBase,
    private val movieApi: MoviesApi
) : RemoteMediator<Int, MovieEntity>() {

    var searchType: SearchType? = null

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, MovieEntity>
    ): MediatorResult {
        return try {
            if (searchType == null) throw NullPointerException("SearchType cannot be null")

            val loadKey = getLoadKey(loadType, state, searchType!!.toApiQuery().page!!)

            val movies = fetchMovies(searchType!!, loadKey)

            databaseTransaction(loadType, movies)

            MediatorResult.Success(
                endOfPaginationReached = movies.page > 500
            )
        } catch (e: IOException) {
            MediatorResult.Error(e)
        } catch (e: HttpException) {
            MediatorResult.Error(e)
        }
    }

    private suspend fun fetchMovies(searchType: SearchType, page: Int): MoviesResponse {

        val queryParams = searchType.toApiQuery()

        return movieApi.fetchMovies(
            genreId = queryParams.genreId,
            sortBy = queryParams.sortBy,
            releaseType = queryParams.releaseType,
            releaseDateGte = queryParams.releaseDateGte,
            releaseDateLte = queryParams.releaseDateLte,
            voteCountGte = queryParams.voteCount,
            page = queryParams.page,
        )
    }

    private suspend fun databaseTransaction(
        loadType: LoadType,
        movies: MoviesResponse
    ) {
        movieDataBase.withTransaction {
            if (loadType == LoadType.REFRESH) {
                movieDataBase.movieDao().clearAll()
            }
            val movieEntities = movies.results.map { it.toMoviesListEntity() }
            movieDataBase.movieDao().upsertAll(movieEntities)
        }
    }

    private fun getLoadKey(
        loadType: LoadType,
        state: PagingState<Int, MovieEntity>,
        page: Int
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
                    page
                }
            }
        }
        return loadKey
    }
}
