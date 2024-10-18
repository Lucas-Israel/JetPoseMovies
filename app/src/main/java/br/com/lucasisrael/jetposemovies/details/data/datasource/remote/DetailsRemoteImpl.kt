package br.com.lucasisrael.jetposemovies.details.data.datasource.remote

import br.com.lucasisrael.jetposemovies.details.data.api.DetailsApi
import br.com.lucasisrael.jetposemovies.details.data.mappers.toDetailsDto
import br.com.lucasisrael.jetposemovies.details.data.models.remote.DetailsDto
import javax.inject.Inject

class DetailsRemoteImpl @Inject constructor(private val api: DetailsApi) : DetailsRemote {

    override suspend fun getDetailsById(movieId: String): DetailsDto {
        val response = api.getDetailsById(movieId)

        return response.toDetailsDto()
    }

}
