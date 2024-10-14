package br.com.lucasisrael.jetposemovies.moviesgenre.data.datasource.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import br.com.lucasisrael.jetposemovies.moviesgenre.data.models.local.MoviesFromGenreEntity
import br.com.lucasisrael.jetposemovies.moviesgenre.data.models.remote.MoviesFromGenreDto

@Dao
interface MoviesFromGenreDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMoviesFromGenre(moviesFromGenre: MoviesFromGenreDto)

    @Query("SELECT * from moviesFromGenreEntity")
    suspend fun getAllMoviesFromGenre(): MoviesFromGenreEntity

    @Delete
    suspend fun deleteMovieFromGenre(movieFromGenre: MoviesFromGenreEntity)

    @Query("DELETE from moviesFromGenreEntity")
    suspend fun clearAll()
}
