package br.com.lucasisrael.jetposemovies.moviesList.data.datasource.local

import br.com.lucasisrael.jetposemovies.moviesList.data.datasource.database.MoviesListDao
import br.com.lucasisrael.jetposemovies.moviesList.data.mappers.toMoviesFromGenreEntity
import br.com.lucasisrael.jetposemovies.moviesList.data.models.local.MoviesListEntity
import br.com.lucasisrael.jetposemovies.moviesList.data.models.remote.MoviesListDto
import javax.inject.Inject

class MoviesListLocalImpl @Inject constructor(
    private val moviesDao: MoviesListDao
) : MoviesListLocal {

    override suspend fun saveMoviesFromGenreToDataBase(movies: MoviesListDto) {
        moviesDao.insertMoviesFromGenre(movies.toMoviesFromGenreEntity())
    }

    override suspend fun getMoviesFromGenreFromDataBase(): MoviesListEntity {
        return moviesDao.getAllMoviesFromGenre()
    }

}
