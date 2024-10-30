package br.com.lucasisrael.jetposemovies.moviesList.data.api

import br.com.lucasisrael.jetposemovies.moviesList.data.models.response.MoviesListResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesListApi {
    @GET("discover/movie")
    suspend fun getMoviesFromGenre(
        @Query("with_genres") genreId: String,
        @Query("sort_by") sortBy: String = "revenue.desc",
        @Query("page") page: Int = 1
    ): MoviesListResponse
}
