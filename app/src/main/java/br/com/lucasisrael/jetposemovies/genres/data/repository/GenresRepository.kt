package br.com.lucasisrael.jetposemovies.genres.data.repository

import androidx.paging.PagingSource
import br.com.lucasisrael.jetposemovies.genres.data.datasource.local.GenresDao
import br.com.lucasisrael.jetposemovies.genres.data.models.local.GenreEntity
import javax.inject.Inject

class GenresRepository @Inject constructor(
    private val dao: GenresDao,
) {
    fun load(): PagingSource<Int, GenreEntity> {
        return dao.load()
    }
}
