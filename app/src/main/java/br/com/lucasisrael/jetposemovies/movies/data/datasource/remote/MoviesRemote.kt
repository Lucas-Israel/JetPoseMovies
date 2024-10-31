package br.com.lucasisrael.jetposemovies.movies.data.datasource.remote

import br.com.lucasisrael.jetposemovies.movies.data.models.remote.MovieDto

interface MoviesRemote {
    suspend fun fetchMoviesFromGenre(genreId: String, page: Int): List<MovieDto>
    suspend fun fetchUpcomingMovies(page: Int): List<MovieDto>
}
