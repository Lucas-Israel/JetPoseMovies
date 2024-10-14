package br.com.lucasisrael.jetposemovies.details.data.datasource.remote

import br.com.lucasisrael.jetposemovies.details.data.api.DetailsApi
import br.com.lucasisrael.jetposemovies.details.data.mappers.toDetailsDto
import br.com.lucasisrael.jetposemovies.details.data.models.remote.DetailsDto

class DetailsRemoteImpl(val api: DetailsApi) : DetailsRemote {

    override suspend fun getDetailsById(movieId: String): DetailsDto {
        return api.getDetailsById(movieId).toDetailsDto()
    }

}
