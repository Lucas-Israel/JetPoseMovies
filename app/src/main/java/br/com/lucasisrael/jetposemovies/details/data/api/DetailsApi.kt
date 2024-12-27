package br.com.lucasisrael.jetposemovies.details.data.api

import br.com.lucasisrael.jetposemovies.details.models.remote.DetailsDto
import retrofit2.http.GET
import retrofit2.http.Path

interface DetailsApi {
    @GET("movie/{movie_id}")
    suspend fun fetch(
        @Path("movie_id") movieId: Int,
    ): DetailsDto
}
