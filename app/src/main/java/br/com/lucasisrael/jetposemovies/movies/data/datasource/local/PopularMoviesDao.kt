package br.com.lucasisrael.jetposemovies.movies.data.datasource.local

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Upsert
import br.com.lucasisrael.jetposemovies.movies.data.models.local.PopularMoviesEntity
import br.com.lucasisrael.jetposemovies.movies.data.models.local.PopularWithMovie

@Dao
interface PopularMoviesDao {
    @Upsert
    fun upsert(list: List<PopularMoviesEntity>)

    @Query("SELECT * from popular")
    @Transaction
    fun load(): PagingSource<Int, PopularWithMovie>

    @Query("DELETE from popular")
    fun clearAll()

    @Query("DELETE FROM sqlite_sequence WHERE name = 'popular'")
    fun clearPrimaryKey()
}
