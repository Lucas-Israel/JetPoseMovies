package br.com.lucasisrael.jetposemovies.genres.data.datasource.local

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Upsert
import br.com.lucasisrael.jetposemovies.genres.models.local.GenreEntity

@Dao
interface GenresDao {

    @Upsert
    @Transaction
    fun upsert(list: List<GenreEntity>)

    @Query("SELECT * from genres")
    @Transaction
    fun load(): PagingSource<Int, GenreEntity>

    @Query("DELETE from genres")
    @Transaction
    fun clearAll()
}
