package br.com.lucasisrael.jetposemovies.moviesgenre.data.datasource.local

import br.com.lucasisrael.jetposemovies.moviesgenre.data.datasource.database.MoviesFromGenreDao
import br.com.lucasisrael.jetposemovies.moviesgenre.data.models.local.MovieFromGenreEntity
import br.com.lucasisrael.jetposemovies.moviesgenre.data.models.remote.MovieFromGenreDto
import javax.inject.Inject

class MoviesFromGenreLocalImpl @Inject constructor(
    private val moviesDao: MoviesFromGenreDao
) : MoviesFromGenreLocal {

    override suspend fun saveMoviesFromGenreToDataBase(movies: List<MovieFromGenreDto>) {
        moviesDao.insertMoviesFromGenre(movies)
    }

    override suspend fun getMoviesFromGenreFromDataBase(): List<MovieFromGenreEntity> {
        return moviesDao.getAllMoviesFromGenre()
    }

}
