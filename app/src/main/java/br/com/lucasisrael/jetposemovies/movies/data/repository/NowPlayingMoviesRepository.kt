package br.com.lucasisrael.jetposemovies.movies.data.repository

import androidx.paging.PagingSource
import br.com.lucasisrael.jetposemovies.movies.data.datasource.local.NowPlayingDao
import br.com.lucasisrael.jetposemovies.movies.data.models.local.NowPlayingWithMovie
import javax.inject.Inject

class NowPlayingMoviesRepository @Inject constructor(
    private val dao: NowPlayingDao,
) {
    fun load(): PagingSource<Int, NowPlayingWithMovie> {
        return dao.load()
    }
}
