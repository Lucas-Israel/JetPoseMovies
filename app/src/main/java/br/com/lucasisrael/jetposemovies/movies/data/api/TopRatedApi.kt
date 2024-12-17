package br.com.lucasisrael.jetposemovies.movies.data.api

import br.com.lucasisrael.jetposemovies.movies.data.models.response.MoviesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface TopRatedApi {

    @GET("movie/top_rated")
    fun fetch(
        @Query("language") language: String? = null,
        @Query("page") page: Int = 1
    ): MoviesResponse
}
