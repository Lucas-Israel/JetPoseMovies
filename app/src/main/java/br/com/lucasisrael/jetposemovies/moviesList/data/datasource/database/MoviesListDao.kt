package br.com.lucasisrael.jetposemovies.moviesList.data.datasource.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import br.com.lucasisrael.jetposemovies.moviesList.data.models.local.MoviesListEntity

@Dao
interface MoviesListDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMoviesFromGenre(moviesFromGenre: MoviesListEntity)

    @Query("SELECT * from movies_from_genre")
    suspend fun getAllMoviesFromGenre(): MoviesListEntity

    @Delete
    suspend fun deleteMovieFromGenre(movieFromGenre: MoviesListEntity)

    @Query("DELETE from movies_from_genre")
    suspend fun clearAll()
}
