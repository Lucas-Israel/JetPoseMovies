package br.com.lucasisrael.jetposemovies.movies.data.api

import br.com.lucasisrael.jetposemovies.movies.data.models.response.MoviesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesApi {

    @SuppressWarnings("LongParameterList")
    @GET("discover/movie")
    suspend fun fetchMovies(
        @Query("with_genres") genreId: String? = null,
        @Query("sort_by") sortBy: String? = "popularity.desc",
        @Query("with_release_type") releaseType: Int? = null,
        @Query("release_date.gte") releaseDateGte: String? = null,
        @Query("release_date.lte") releaseDateLte: String? = null,
        @Query("page") page: Int? = 1
    ) : MoviesResponse
}
