package br.com.lucasisrael.jetposemovies.genres.data.datasource.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import br.com.lucasisrael.jetposemovies.genres.data.models.local.GenreEntity

@Dao
interface GenreDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGenres(genres: List<GenreEntity>)

    @Query("SELECT * from genreentity")
    suspend fun getAllGenres(): List<GenreEntity>

    @Delete
    suspend fun deleteGenre(genre: GenreEntity)

    @Query("DELETE from genreentity")
    suspend fun clearAll()
}
