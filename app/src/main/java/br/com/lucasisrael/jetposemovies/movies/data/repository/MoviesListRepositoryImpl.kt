package br.com.lucasisrael.jetposemovies.movies.data.repository

import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.room.withTransaction
import br.com.lucasisrael.jetposemovies.common.coroutines.safeApiCall
import br.com.lucasisrael.jetposemovies.common.models.Resource
import br.com.lucasisrael.jetposemovies.movies.data.datasource.database.MoviesDataBase
import br.com.lucasisrael.jetposemovies.movies.data.datasource.remote.MoviesRemote
import br.com.lucasisrael.jetposemovies.movies.data.mappers.toMoviesListEntity
import br.com.lucasisrael.jetposemovies.movies.data.models.local.MovieEntity
import br.com.lucasisrael.jetposemovies.movies.data.models.query.MovieApiQuery
import coil.network.HttpException
import java.io.IOException
import javax.inject.Inject

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
class MoviesListRepositoryImpl @Inject constructor(
    private val moviesRemote: MoviesRemote,
    private val moviesDataBase: MoviesDataBase,
) : MoviesListRepository<MovieEntity>() {

    private var query = MovieApiQuery()

    fun setQuery(query: MovieApiQuery) {
        this.query = query
    }

    fun getQuery(): MovieApiQuery {
        return this.query
    }

    @ExperimentalPagingApi
    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, MovieEntity>
    ): MediatorResult {
        return try {

            val movies = safeApiCall {
                moviesRemote.fetchMovies(query)
            }

            moviesDataBase.withTransaction {
                if (loadType == LoadType.REFRESH) {
                    moviesDataBase.movieDao().clearAll()
                }
                when (movies) {
                    is Resource.Success -> {
                        val moviesEntity = movies.data!!.results.map { it.toMoviesListEntity() }

                        moviesDataBase.movieDao().upsertAll(moviesEntity)

                        MediatorResult.Success(
                            endOfPaginationReached = movies.data.page > 500
                        )

                    }

                    is Resource.Error -> {
                        MediatorResult.Error(IOException(movies.message))
                    }
                }
            }

        } catch (e: IOException) {
            MediatorResult.Error(e)
        } catch (e: HttpException) {
            MediatorResult.Error(e)
        }
    }

}
