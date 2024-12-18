package br.com.lucasisrael.jetposemovies.movies.data.repository

import androidx.paging.PagingSource
import br.com.lucasisrael.jetposemovies.movies.data.datasource.local.TopRatedDao
import br.com.lucasisrael.jetposemovies.movies.data.models.local.TopRatedWithMovie
import javax.inject.Inject

class TopRatedMoviesRepository @Inject constructor(
    private val dao: TopRatedDao,
) {
    fun load(): PagingSource<Int, TopRatedWithMovie> {
        return dao.load()
    }
}
