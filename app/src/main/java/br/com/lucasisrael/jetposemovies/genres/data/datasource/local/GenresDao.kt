package br.com.lucasisrael.jetposemovies.genres.data.datasource.local

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import br.com.lucasisrael.jetposemovies.genres.data.models.local.GenreEntity

@Dao
interface GenresDao {

    @Upsert
    fun upsert(list: List<GenreEntity>)

    @Query("SELECT * from genres")
    fun load(): PagingSource<Int, GenreEntity>

    @Query("DELETE from genres")
    fun clearAll()
}
