package br.com.lucasisrael.jetposemovies.details.data.datasource.local

import br.com.lucasisrael.jetposemovies.details.data.models.local.DetailsEntity

interface DetailsLocal {
    suspend fun saveDetails(details: DetailsEntity)
    suspend fun getDetailsFromDataBase(): DetailsEntity
}
