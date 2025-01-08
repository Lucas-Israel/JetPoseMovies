package br.com.lucasisrael.jetposemovies.details.data.api

import br.com.lucasisrael.jetposemovies.common.utils.constants.Constants.DETAILS_URL
import br.com.lucasisrael.jetposemovies.details.models.remote.DetailsDto
import retrofit2.http.GET
import retrofit2.http.Path

interface DetailsApi {
    @GET(DETAILS_URL)
    suspend fun fetch(
        @Path("movie_id") movieId: Int,
    ): DetailsDto
}
