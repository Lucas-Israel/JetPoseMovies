package br.com.lucasisrael.jetposemovies.movies.data.datasource.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Upsert
import br.com.lucasisrael.jetposemovies.movies.data.models.local.MovieEntity

@Dao
interface MoviesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMoviesFromGenre(moviesFromGenre: MovieEntity)

    @Upsert
    suspend fun upsertAll(movies: List<MovieEntity>)

    @Query(
        "SELECT * from movies_from_genre" +
                " WHERE genre_ids LIKE '%' || :genreId || '%'" +
                " ORDER BY popularity DESC LIMIT 20"
    )
    suspend fun getAllMoviesFromGenre(genreId: String): List<MovieEntity>

    @Query(
        "SELECT * from movies_from_genre ORDER BY release_date DESC LIMIT 5"
    )
    suspend fun getUpcomingMovies(): List<MovieEntity>

    @Query(
        "SELECT * from movies_from_genre ORDER BY popularity DESC LIMIT 20"
    )
    suspend fun getPopularMovies(): List<MovieEntity>

    @Delete
    suspend fun deleteMovieFromGenre(movieFromGenre: MovieEntity)

    @Query("DELETE from movies_from_genre")
    suspend fun clearAll()
}
