package br.com.lucasisrael.jetposemovies.genres.data.api

import br.com.lucasisrael.jetposemovies.common.utils.constants.Constants.GENRES_URL
import br.com.lucasisrael.jetposemovies.genres.models.response.GenreResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface GenresApi {
    @GET(GENRES_URL)
    suspend fun fetch(
        @Query("language") language: String? = "en-US",
        @Query("page") page: Int
    ): GenreResponse
}
