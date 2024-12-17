package br.com.lucasisrael.jetposemovies.movies.data.repository

import androidx.paging.PagingSource
import br.com.lucasisrael.jetposemovies.movies.data.datasource.local.MovieDao
import br.com.lucasisrael.jetposemovies.movies.data.models.local.MovieEntity
import javax.inject.Inject

class MoviesRepository @Inject constructor(
    private val movieDao: MovieDao,
) {
    fun load(genreId: String): PagingSource<Int, MovieEntity> {
        return movieDao.load(genreId)
    }
}
