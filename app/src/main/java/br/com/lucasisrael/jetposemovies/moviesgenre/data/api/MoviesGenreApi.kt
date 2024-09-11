package br.com.lucasisrael.jetposemovies.moviesgenre.data.api

import br.com.lucasisrael.jetposemovies.moviesgenre.data.response.MoviesFromGenreResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesGenreApi {
    @GET("discover/movie")
    suspend fun getMoviesFromGenre(
        @Query("with_genres") id: String,
        @Query("sort_by") sortBy: String = "revenue.desc",
    ): MoviesFromGenreResponse
}
