package br.com.lucasisrael.jetposemovies.movies.data.api

import br.com.lucasisrael.jetposemovies.common.utils.constants.Constants.MOVIE_BY_ID_URL
import br.com.lucasisrael.jetposemovies.movies.models.response.MoviesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesApi {

    @GET(MOVIE_BY_ID_URL)
    suspend fun fetch(
        @Query("adult") adult: String = "false",
        @Query("with_genres") genreId: Int,
        @Query("language") language: String = "en-US",
        @Query("page") page: Int,
        @Query("sort_by") sortBy: String = "popularity.desc"
    ): MoviesResponse
}
