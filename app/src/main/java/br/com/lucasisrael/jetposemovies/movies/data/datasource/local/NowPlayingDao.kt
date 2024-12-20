package br.com.lucasisrael.jetposemovies.movies.data.datasource.local

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Upsert
import br.com.lucasisrael.jetposemovies.movies.data.models.local.NowPlayingMoviesEntity
import br.com.lucasisrael.jetposemovies.movies.data.models.local.NowPlayingWithMovies

@Dao
interface NowPlayingDao {
    @Upsert
    fun upsert(list: List<NowPlayingMoviesEntity>)

    @Query("SELECT * from now_playing")
    @Transaction
    fun load(): PagingSource<Int, NowPlayingWithMovies>

    @Query("DELETE from now_playing")
    fun clearAll()

    @Query("DELETE from sqlite_sequence WHERE name = 'now_playing'")
    fun clearPrimaryKey()
}
