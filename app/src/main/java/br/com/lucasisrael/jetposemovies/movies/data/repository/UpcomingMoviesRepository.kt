package br.com.lucasisrael.jetposemovies.movies.data.repository

import androidx.paging.PagingSource
import br.com.lucasisrael.jetposemovies.movies.data.datasource.local.UpcomingMoviesDao
import br.com.lucasisrael.jetposemovies.movies.data.models.local.UpcomingWithMovie
import javax.inject.Inject

class UpcomingMoviesRepository @Inject constructor(
    private val dao: UpcomingMoviesDao
) {
    fun load(): PagingSource<Int, UpcomingWithMovie> {
        return dao.load()
    }
}
