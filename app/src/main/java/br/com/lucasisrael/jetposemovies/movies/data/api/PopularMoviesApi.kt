package br.com.lucasisrael.jetposemovies.movies.data.api

import br.com.lucasisrael.jetposemovies.movies.data.models.response.MoviesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface PopularMoviesApi {
    @GET("movie/popular")
    suspend fun fetch(
        @Query("language") language: String? = "en-US",
        @Query("page") page: Int
    ) : MoviesResponse
}