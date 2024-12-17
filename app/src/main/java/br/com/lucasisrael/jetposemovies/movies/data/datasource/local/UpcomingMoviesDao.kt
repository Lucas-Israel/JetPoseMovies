package br.com.lucasisrael.jetposemovies.movies.data.datasource.local

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Upsert
import br.com.lucasisrael.jetposemovies.movies.data.models.local.UpcomingMoviesEntity
import br.com.lucasisrael.jetposemovies.movies.data.models.local.UpcomingWithMovie

@Dao
interface UpcomingMoviesDao {
    @Upsert
    fun upsert(list: List<UpcomingMoviesEntity>)

    @Query("SELECT * from upcoming LIMIT 5")
    @Transaction
    fun load(): PagingSource<Int, UpcomingWithMovie>

    @Query("DELETE from upcoming")
    fun clearAll()
}
