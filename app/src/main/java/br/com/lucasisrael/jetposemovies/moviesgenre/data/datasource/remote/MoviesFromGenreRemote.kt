package br.com.lucasisrael.jetposemovies.moviesgenre.data.datasource.remote

import br.com.lucasisrael.jetposemovies.moviesgenre.data.models.response.MoviesFromGenreResponse

interface MoviesFromGenreRemote {
    suspend fun getMoviesFromGenre(id: String, page: Int): MoviesFromGenreResponse
}
