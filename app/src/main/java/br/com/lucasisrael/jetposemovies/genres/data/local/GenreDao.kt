package br.com.lucasisrael.jetposemovies.genres.data.local

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import br.com.lucasisrael.jetposemovies.genres.data.models.local.GenreEntity

@Dao
interface GenreDao {

    @Upsert
    suspend fun upsertAll(genres: List<GenreEntity>)

    @Query("SELECT * from genreentity")
    fun pagingSource(): PagingSource<Int, GenreEntity>

    @Query("DELETE from genreentity")
    suspend fun clearAll()
}
