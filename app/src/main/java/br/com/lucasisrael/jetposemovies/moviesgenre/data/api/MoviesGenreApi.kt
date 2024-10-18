package br.com.lucasisrael.jetposemovies.moviesgenre.data.api

import br.com.lucasisrael.jetposemovies.moviesgenre.data.models.remote.MoviesFromGenreDto
import br.com.lucasisrael.jetposemovies.moviesgenre.data.models.response.MoviesFromGenreResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesGenreApi {
    @GET("discover/movie")
    suspend fun getMoviesFromGenre(
        @Query("with_genres") genreId: String,
        @Query("sort_by") sortBy: String = "revenue.desc",
        @Query("page") page: Int = 1
    ): MoviesFromGenreResponse
}
