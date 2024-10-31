package br.com.lucasisrael.jetposemovies.movies.data.repository

import android.os.Build
import androidx.annotation.RequiresExtension
import br.com.lucasisrael.jetposemovies.common.coroutines.safeApiCall
import br.com.lucasisrael.jetposemovies.common.models.Resource
import br.com.lucasisrael.jetposemovies.movies.data.datasource.local.MoviesLocal
import br.com.lucasisrael.jetposemovies.movies.data.datasource.remote.MoviesRemote
import br.com.lucasisrael.jetposemovies.movies.data.models.local.MovieEntity
import br.com.lucasisrael.jetposemovies.movies.data.models.remote.MovieDto
import javax.inject.Inject

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
class MoviesListRepositoryImpl @Inject constructor(
    private val moviesRemote: MoviesRemote,
    private val moviesLocal: MoviesLocal,
) : MoviesListRepository {

    override suspend fun getMoviesFromGenreFromApi(
        genreId: String,
        page: Int
    ): Resource<List<MovieDto?>?> {
        return safeApiCall {
            moviesRemote.fetchMoviesFromGenre(genreId, page)
        }
    }

    override suspend fun saveMoviesFromGenreToDataBase(movieDto: MovieDto) {
        moviesLocal.saveMoviesToDataBase(movieDto)
    }

    override suspend fun loadMoviesFromGenreFromDataBase(genreId: String): List<MovieEntity> {
        return moviesLocal.getMoviesFromGenreFromDataBase(genreId)
    }
}
