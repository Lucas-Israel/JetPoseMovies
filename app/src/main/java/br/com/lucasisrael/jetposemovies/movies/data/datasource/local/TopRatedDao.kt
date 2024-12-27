package br.com.lucasisrael.jetposemovies.movies.data.datasource.local

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Upsert
import br.com.lucasisrael.jetposemovies.movies.data.mappers.toEntity
import br.com.lucasisrael.jetposemovies.movies.data.mappers.toTopRatedMovieEntity
import br.com.lucasisrael.jetposemovies.movies.models.local.MovieEntity
import br.com.lucasisrael.jetposemovies.movies.models.local.TopRatedMoviesEntity
import br.com.lucasisrael.jetposemovies.movies.models.local.TopRatedWithMovie
import br.com.lucasisrael.jetposemovies.movies.models.remote.MovieDto

@Dao
interface TopRatedDao {

    @Upsert
    @Transaction
    fun upsert(list: List<MovieDto>) {
        upsertMovies(list.map { it.toEntity() })
        upsertTopRated(list.map { it.toTopRatedMovieEntity() })
    }

    @Query("SELECT * from top_rated")
    @Transaction
    fun load(): PagingSource<Int, TopRatedWithMovie>

    @Query("DELETE from top_rated")
    @Transaction
    fun clearAll()

    @Query("SELECT COUNT(*) from top_rated")
    @Transaction
    fun getCount(): Int

    @Upsert
    @Transaction
    fun upsertMovies(list: List<MovieEntity>)

    @Upsert
    @Transaction
    fun upsertTopRated(list: List<TopRatedMoviesEntity>)
}
