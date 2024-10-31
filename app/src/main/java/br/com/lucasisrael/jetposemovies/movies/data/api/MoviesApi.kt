package br.com.lucasisrael.jetposemovies.movies.data.api

import br.com.lucasisrael.jetposemovies.movies.data.models.response.MoviesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesApi {

    @GET("discover/movie")
    suspend fun getMoviesFromGenre(
        @Query("with_genres") genreId: String,
        @Query("sort_by") sortBy: String = "revenue.desc",
        @Query("page") page: Int = 1
    ): MoviesResponse

    @GET("discover/movie")
    suspend fun fetchUpComingMovies(
        @Query("sort_by") sortBy: String = "popularity.desc",
        @Query("with_release_type") releaseType: Int = 2 or 3,
        @Query("release_date.gte") releaseDateGte: String = "{min_date}",
        @Query("release_date.lte") releaseDateLte: String = "{max_date}",
        @Query("page") page: Int = 1
    ) : MoviesResponse
}
