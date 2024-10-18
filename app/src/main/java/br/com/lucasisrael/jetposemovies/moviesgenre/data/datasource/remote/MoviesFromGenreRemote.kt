package br.com.lucasisrael.jetposemovies.moviesgenre.data.datasource.remote

import br.com.lucasisrael.jetposemovies.moviesgenre.data.models.remote.MoviesFromGenreDto

interface MoviesFromGenreRemote {
    suspend fun getMoviesFromGenre(genreId: String, page: Int): MoviesFromGenreDto
}
