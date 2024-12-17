package br.com.lucasisrael.jetposemovies.movies.data.repository

import androidx.paging.PagingSource
import br.com.lucasisrael.jetposemovies.movies.data.datasource.local.PopularMoviesDao
import br.com.lucasisrael.jetposemovies.movies.data.models.local.PopularWithMovie
import javax.inject.Inject

class PopularMoviesRepository @Inject constructor(
    private val dao: PopularMoviesDao
) {
    fun load(): PagingSource<Int, PopularWithMovie> {
        return dao.load()
    }
}
