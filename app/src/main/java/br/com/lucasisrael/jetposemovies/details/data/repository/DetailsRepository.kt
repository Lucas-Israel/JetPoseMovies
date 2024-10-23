package br.com.lucasisrael.jetposemovies.details.data.repository

import br.com.lucasisrael.jetposemovies.common.models.Resource
import br.com.lucasisrael.jetposemovies.details.data.models.local.DetailsEntity
import br.com.lucasisrael.jetposemovies.details.data.models.remote.DetailsDto

interface DetailsRepository {
    suspend fun getDetailsByIdFromApi(movieId: String): Resource<DetailsDto?>
    suspend fun saveDetailsToDb(detailsDto: DetailsDto)
    suspend fun loadDetailsFromDb(movieId: String): DetailsEntity
}
