package br.com.lucasisrael.jetposemovies.moviesgenre.data.datasource

import br.com.lucasisrael.jetposemovies.moviesgenre.data.respose.MoviesFromGenreResponse

interface MoviesFromGenreDataSource {
    suspend fun getMoviesFromGenre(id: String): MoviesFromGenreResponse
}
