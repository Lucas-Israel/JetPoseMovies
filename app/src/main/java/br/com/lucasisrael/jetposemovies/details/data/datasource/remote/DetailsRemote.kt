package br.com.lucasisrael.jetposemovies.details.data.datasource.remote

import br.com.lucasisrael.jetposemovies.details.data.models.remote.DetailsDto

interface DetailsRemote {
    suspend fun getDetailsById(movieId: String) : DetailsDto
}
