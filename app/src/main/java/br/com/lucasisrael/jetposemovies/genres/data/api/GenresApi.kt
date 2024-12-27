package br.com.lucasisrael.jetposemovies.genres.data.api

import br.com.lucasisrael.jetposemovies.genres.data.models.response.GenreResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface GenresApi {
    @GET("genre/movie/list?")
    suspend fun fetch(
        @Query("language") language: String? = "en-US",
        @Query("page") page: Int
    ): GenreResponse
}
