package br.com.lucasisrael.jetposemovies.details.data.datasource.local

import br.com.lucasisrael.jetposemovies.details.data.datasource.database.DetailsDao
import br.com.lucasisrael.jetposemovies.details.data.models.local.DetailsEntity
import javax.inject.Inject

class DetailsLocalImpl @Inject constructor(
    private val detailsDao: DetailsDao
): DetailsLocal {

    override suspend fun saveDetails(details: DetailsEntity) {
        detailsDao.insertDetails(details)
    }

    override suspend fun getDetailsFromDataBase(): DetailsEntity {
        return detailsDao.getDetails()
    }
}
