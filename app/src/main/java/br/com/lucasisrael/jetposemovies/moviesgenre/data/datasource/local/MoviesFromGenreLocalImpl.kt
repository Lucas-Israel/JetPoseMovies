package br.com.lucasisrael.jetposemovies.moviesgenre.data.datasource.local

import br.com.lucasisrael.jetposemovies.moviesgenre.data.datasource.database.MoviesFromGenreDao
import br.com.lucasisrael.jetposemovies.moviesgenre.data.models.local.MoviesFromGenreEntity
import br.com.lucasisrael.jetposemovies.moviesgenre.data.models.remote.MoviesFromGenreDto
import javax.inject.Inject

class MoviesFromGenreLocalImpl @Inject constructor(
    private val moviesDao: MoviesFromGenreDao
) : MoviesFromGenreLocal {

    override suspend fun saveMoviesFromGenreToDataBase(movies: MoviesFromGenreDto) {
        moviesDao.insertMoviesFromGenre(movies)
    }

    override suspend fun getMoviesFromGenreFromDataBase(): MoviesFromGenreEntity {
        return moviesDao.getAllMoviesFromGenre()
    }

}
