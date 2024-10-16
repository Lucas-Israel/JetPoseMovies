package br.com.lucasisrael.jetposemovies.details.data.datasource.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import br.com.lucasisrael.jetposemovies.details.data.models.local.DetailsEntity

@Dao
interface DetailsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDetails(details: DetailsEntity)

    @Query("SELECT * from details_structure")
    suspend fun getDetails(): DetailsEntity

    @Query("DELETE from details_structure")
    suspend fun clear()

}
