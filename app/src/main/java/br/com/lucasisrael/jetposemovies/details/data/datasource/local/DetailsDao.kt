package br.com.lucasisrael.jetposemovies.details.data.datasource.local

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Upsert
import br.com.lucasisrael.jetposemovies.details.models.local.DetailsEntity

@Dao
interface DetailsDao {

    @Upsert
    @Transaction
    fun upsert(details: DetailsEntity)

    @Query("SELECT * from details WHERE id = :detailId")
    @Transaction
    fun load(detailId: Int): PagingSource<Int, DetailsEntity>

    @Query("DELETE from details")
    @Transaction
    fun clearAll()
}
