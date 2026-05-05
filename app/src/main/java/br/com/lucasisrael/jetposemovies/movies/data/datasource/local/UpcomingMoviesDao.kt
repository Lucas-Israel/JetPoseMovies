package br.com.lucasisrael.jetposemovies.movies.data.datasource.local

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Upsert
import br.com.lucasisrael.jetposemovies.movies.data.mappers.toEntity
import br.com.lucasisrael.jetposemovies.movies.data.mappers.toUpcomingMovieEntity
import br.com.lucasisrael.jetposemovies.movies.models.local.MovieEntity
import br.com.lucasisrael.jetposemovies.movies.models.local.UpcomingMoviesEntity
import br.com.lucasisrael.jetposemovies.movies.models.local.UpcomingWithMovie
import br.com.lucasisrael.jetposemovies.movies.models.remote.MovieDto

@Dao
interface UpcomingMoviesDao {

    @Upsert
    @Transaction
    fun upsert(list: List<MovieDto>) {
        upsertMovies(list.map { it.toEntity() })
        upsertUpcoming(list.map { it.toUpcomingMovieEntity() })
    }

    @Query("SELECT * from upcoming")
    @Transaction
    fun load(): PagingSource<Int, UpcomingWithMovie>

    @Query("DELETE from upcoming")
    @Transaction
    fun clearAll()

    @Query("SELECT COUNT(*) from upcoming")
    @Transaction
    fun getCount(): Int

    @Upsert
    @Transaction
    fun upsertMovies(list: List<MovieEntity>)

    @Upsert
    @Transaction
    fun upsertUpcoming(list: List<UpcomingMoviesEntity>)
}
