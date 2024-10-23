package br.com.lucasisrael.jetposemovies.details.data.datasource.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import br.com.lucasisrael.jetposemovies.details.data.models.local.DetailsEntity

@Dao
interface DetailsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDetails(details: DetailsEntity)

    @Query("SELECT * from details_structure")
    suspend fun getDetails(): List<DetailsEntity>

    @Query("SELECT * from details_structure WHERE id = :movieId")
    suspend fun getDetailsByMovieId(movieId: String): DetailsEntity

    @Query("DELETE from details_structure")
    suspend fun clear()

}
