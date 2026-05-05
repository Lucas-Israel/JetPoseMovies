package br.com.lucasisrael.jetposemovies.movies.data.api

import br.com.lucasisrael.jetposemovies.common.utils.constants.Constants.TOP_RATED_URL
import br.com.lucasisrael.jetposemovies.movies.models.response.MoviesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface TopRatedApi {

    @GET(TOP_RATED_URL)
    suspend fun fetch(
        @Query("adult") adult: String = "false",
        @Query("language") language: String? = "en-US",
        @Query("page") page: Int? = 1
    ): MoviesResponse
}
