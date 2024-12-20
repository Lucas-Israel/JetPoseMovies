package br.com.lucasisrael.jetposemovies.movies.data.datasource.local

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Upsert
import br.com.lucasisrael.jetposemovies.movies.data.models.local.NowPlayingMovieEntity
import br.com.lucasisrael.jetposemovies.movies.data.models.local.NowPlayingWithMovie

@Dao
interface NowPlayingDao {
    @Upsert
    fun upsert(list: List<NowPlayingMovieEntity>)

    @Query("SELECT * from now_playing")
    @Transaction
    fun load(): PagingSource<Int, NowPlayingWithMovie>

    @Query("DELETE from now_playing")
    fun clearAll()

    @Query("DELETE from sqlite_sequence WHERE name = 'now_playing'")
    fun clearPrimaryKey()
}
