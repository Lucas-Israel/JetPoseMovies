package br.com.lucasisrael.jetposemovies.moviesgenre.data.datasource.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import br.com.lucasisrael.jetposemovies.moviesgenre.data.models.local.MovieFromGenreEntity
import br.com.lucasisrael.jetposemovies.moviesgenre.data.models.remote.MovieFromGenreDto

@Dao
interface MoviesFromGenreDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMoviesFromGenre(moviesFromGenre: List<MovieFromGenreDto>)

    @Query("SELECT * from movieFromGenreEntity")
    suspend fun getAllMoviesFromGenre(): List<MovieFromGenreEntity>

    @Delete
    suspend fun deleteMovieFromGenre(movieFromGenre: MovieFromGenreEntity)

    @Query("DELETE from movieFromGenreEntity")
    suspend fun clearAll()
}
