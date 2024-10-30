package br.com.lucasisrael.jetposemovies.moviesList.data.datasource.remote

import br.com.lucasisrael.jetposemovies.moviesList.data.models.remote.MoviesListDto

interface MoviesListRemote {
    suspend fun getMoviesFromGenre(genreId: String, page: Int): MoviesListDto
}
