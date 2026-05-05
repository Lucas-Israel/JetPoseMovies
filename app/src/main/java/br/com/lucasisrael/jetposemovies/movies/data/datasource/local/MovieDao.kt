package br.com.lucasisrael.jetposemovies.movies.data.datasource.local

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Upsert
import br.com.lucasisrael.jetposemovies.movies.data.mappers.toEntity
import br.com.lucasisrael.jetposemovies.movies.data.mappers.toMovieGenreIdsEntityList
import br.com.lucasisrael.jetposemovies.movies.models.local.MovieEntity
import br.com.lucasisrael.jetposemovies.movies.models.local.MovieGenreIdsEntity
import br.com.lucasisrael.jetposemovies.movies.models.local.MovieGenreIdsWithMovie
import br.com.lucasisrael.jetposemovies.movies.models.remote.MovieDto

@Dao
interface MovieDao {

    @Upsert
    @Transaction
    fun upsert(list: List<MovieDto>) {
        upsertMovies(list.map { it.toEntity() })
        list.forEach { upsertMoviesGenresById(it.toMovieGenreIdsEntityList()) }
    }

    @Query("SELECT * FROM movie_genres_ids WHERE genre_id LIKE '%'||:genreId||'%'")
    @Transaction
    fun load(genreId: Int): PagingSource<Int, MovieGenreIdsWithMovie>

    @Query("SELECT COUNT(*) FROM movie_genres_ids WHERE genre_id LIKE '%'||:genreId||'%'")
    @Transaction
    fun getCount(genreId: Int): Int

    @Upsert
    @Transaction
    fun upsertMovies(list: List<MovieEntity>)

    @Upsert
    @Transaction
    fun upsertMoviesGenresById(list: List<MovieGenreIdsEntity>)

    @Transaction
    fun clearAll() {
        clearAllMovies()
        clearAllMoviesGenreIds()
    }

    @Query("DELETE FROM movies")
    @Transaction
    fun clearAllMovies()

    @Query("DELETE FROM movie_genres_ids")
    @Transaction
    fun clearAllMoviesGenreIds()
}
