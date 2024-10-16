package br.com.lucasisrael.jetposemovies.details.data.api

import br.com.lucasisrael.jetposemovies.details.data.models.response.DetailsResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface DetailsApi {
    @GET("movie/{movie_id}")
    suspend fun getDetailsById(@Path("movie_id") movieId: String) : DetailsResponse
}
