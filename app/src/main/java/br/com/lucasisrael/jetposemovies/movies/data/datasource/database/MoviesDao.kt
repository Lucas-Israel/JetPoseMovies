package br.com.lucasisrael.jetposemovies.movies.data.datasource.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import br.com.lucasisrael.jetposemovies.movies.data.models.local.MovieEntity

@Dao
interface MoviesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMoviesFromGenre(moviesFromGenre: MovieEntity)

    @Query("SELECT * from movies_from_genre")
    suspend fun getAllMoviesFromGenre(): List<MovieEntity>

    @Delete
    suspend fun deleteMovieFromGenre(movieFromGenre: MovieEntity)

    @Query("DELETE from movies_from_genre")
    suspend fun clearAll()
}
