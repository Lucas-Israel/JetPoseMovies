package br.com.lucasisrael.jetposemovies.details.data.repository

import br.com.lucasisrael.jetposemovies.common.models.Resource
import br.com.lucasisrael.jetposemovies.details.data.models.domain.Details

interface DetailsRepository {
    suspend fun getDetails(movieId: String): Resource<Details?>
    suspend fun refreshDetails(movieId: String)
}
