package br.com.lucasisrael.jetposemovies.movies.data.datasource.local

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Upsert
import br.com.lucasisrael.jetposemovies.movies.data.models.local.TopRatedMoviesEntity
import br.com.lucasisrael.jetposemovies.movies.data.models.local.TopRatedWithMovie

@Dao
interface TopRatedDao {
    @Upsert
    fun upsert(list: List<TopRatedMoviesEntity>)

    @Query("SELECT * from top_rated")
    @Transaction
    fun load(): PagingSource<Int, TopRatedWithMovie>

    @Query("DELETE from top_rated")
    fun clearAll()

    @Query("DELETE FROM sqlite_sequence WHERE name = 'top_rated'")
    fun clearPrimaryKey()
}
