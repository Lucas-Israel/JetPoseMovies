package br.com.lucasisrael.jetposemovies.movies.data.datasource.local

import androidx.paging.PagingSource
import androidx.room.Dao

import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Upsert
import br.com.lucasisrael.jetposemovies.movies.data.mappers.toEntity
import br.com.lucasisrael.jetposemovies.movies.data.mappers.toNowPlayingMovieEntity
import br.com.lucasisrael.jetposemovies.movies.models.local.MovieEntity
import br.com.lucasisrael.jetposemovies.movies.models.local.NowPlayingMovieEntity
import br.com.lucasisrael.jetposemovies.movies.models.local.NowPlayingWithMovie
import br.com.lucasisrael.jetposemovies.movies.models.remote.MovieDto

@Dao
interface NowPlayingDao {

    @Upsert
    @Transaction
    fun upsert(list: List<MovieDto>) {
        upsertMovies(list.map { it.toEntity() })
        upsertNowPlayingMovies(list.map { it.toNowPlayingMovieEntity() })
    }

    @Query("SELECT * from now_playing")
    @Transaction
    fun load(): PagingSource<Int, NowPlayingWithMovie>

    @Query("DELETE from now_playing")
    @Transaction
    fun clearAll()

    @Query("SELECT COUNT(*) from now_playing")
    @Transaction
    fun getCount(): Int

    @Upsert
    @Transaction
    fun upsertMovies(list: List<MovieEntity>)

    @Upsert
    @Transaction
    fun upsertNowPlayingMovies(list: List<NowPlayingMovieEntity>)
}
