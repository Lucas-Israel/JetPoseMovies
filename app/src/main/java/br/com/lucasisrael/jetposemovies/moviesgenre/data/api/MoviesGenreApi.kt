package br.com.lucasisrael.jetposemovies.moviesgenre.data.api

import br.com.lucasisrael.jetposemovies.moviesgenre.data.respose.MoviesFromGenreResponse
import retrofit2.http.GET

interface MoviesGenreApi {
    @GET("discover/movie?include_video=false&language=en-US&page=1&sort_by=popularity.desc&with_genres=28")
    suspend fun getMoviesFromGenre(): MoviesFromGenreResponse
}
