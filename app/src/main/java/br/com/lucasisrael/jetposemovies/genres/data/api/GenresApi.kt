package br.com.lucasisrael.jetposemovies.genres.data.api

import br.com.lucasisrael.jetposemovies.genres.data.models.response.GenreResponse
import retrofit2.http.GET

interface GenresApi {
    @GET("genre/movie/list?language=en")
    suspend fun getGenres(): List<GenreResponse>
}
