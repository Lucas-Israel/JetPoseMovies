package br.com.lucasisrael.jetposemovies.movies.data.datasource.local

import br.com.lucasisrael.jetposemovies.movies.data.datasource.database.MoviesDao
import br.com.lucasisrael.jetposemovies.movies.data.mappers.toMoviesListEntity
import br.com.lucasisrael.jetposemovies.movies.data.models.local.MovieEntity
import br.com.lucasisrael.jetposemovies.movies.data.models.remote.MovieDto
import javax.inject.Inject

class MoviesLocalImpl @Inject constructor(
    private val moviesDao: MoviesDao
) : MoviesLocal {

    override suspend fun saveMoviesToDataBase(movies: MovieDto) {
        moviesDao.insertMoviesFromGenre(movies.toMoviesListEntity())
    }

    override suspend fun getMoviesFromDataBase(genreId: String): List<MovieEntity> {
        return moviesDao.getAllMoviesFromGenre(genreId)
    }

}
