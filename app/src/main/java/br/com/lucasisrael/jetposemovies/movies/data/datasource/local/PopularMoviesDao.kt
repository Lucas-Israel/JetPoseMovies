package br.com.lucasisrael.jetposemovies.movies.data.datasource.local

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Upsert
import br.com.lucasisrael.jetposemovies.movies.data.mappers.toEntity
import br.com.lucasisrael.jetposemovies.movies.data.mappers.toPopularMovieEntity
import br.com.lucasisrael.jetposemovies.movies.models.local.MovieEntity
import br.com.lucasisrael.jetposemovies.movies.models.local.PopularMoviesEntity
import br.com.lucasisrael.jetposemovies.movies.models.local.PopularWithMovie
import br.com.lucasisrael.jetposemovies.movies.models.remote.MovieDto

@Dao
interface PopularMoviesDao {

    @Upsert
    @Transaction
    fun upsert(list: List<MovieDto>) {
        upsertMovies(list = list.map { it.toEntity() })
        upsertPopularMovies(list = list.map { it.toPopularMovieEntity() })
    }

    @Query("SELECT * from popular")
    @Transaction
    fun load(): PagingSource<Int, PopularWithMovie>

    @Query("DELETE from popular")
    @Transaction
    fun clearAll()

    @Query("SELECT COUNT(*) from popular")
    @Transaction
    fun getCount(): Int

    @Upsert
    @Transaction
    fun upsertMovies(list: List<MovieEntity>)

    @Upsert
    @Transaction
    fun upsertPopularMovies(list: List<PopularMoviesEntity>)
}
