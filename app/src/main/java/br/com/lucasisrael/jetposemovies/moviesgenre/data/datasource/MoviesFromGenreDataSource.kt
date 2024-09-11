package br.com.lucasisrael.jetposemovies.moviesgenre.data.datasource

import br.com.lucasisrael.jetposemovies.moviesgenre.data.response.MoviesFromGenreResponse

interface MoviesFromGenreDataSource {
    suspend fun getMoviesFromGenre(id: String): MoviesFromGenreResponse
}
