package br.com.lucasisrael.jetposemovies.moviesgenre.data.datasource.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import br.com.lucasisrael.jetposemovies.moviesgenre.data.models.local.MoviesFromGenreEntity

@Dao
interface MoviesFromGenreDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMoviesFromGenre(moviesFromGenre: MoviesFromGenreEntity)

    @Query("SELECT * from movies_from_genre")
    suspend fun getAllMoviesFromGenre(): MoviesFromGenreEntity

    @Delete
    suspend fun deleteMovieFromGenre(movieFromGenre: MoviesFromGenreEntity)

    @Query("DELETE from movies_from_genre")
    suspend fun clearAll()
}
