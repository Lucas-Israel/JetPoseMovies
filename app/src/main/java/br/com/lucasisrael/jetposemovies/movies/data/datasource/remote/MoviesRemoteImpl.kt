package br.com.lucasisrael.jetposemovies.movies.data.datasource.remote

import br.com.lucasisrael.jetposemovies.movies.data.api.MoviesApi
import br.com.lucasisrael.jetposemovies.movies.data.models.remote.MovieDto
import javax.inject.Inject

class MoviesRemoteImpl @Inject constructor(
    private val moviesApi: MoviesApi,
) :
    MoviesRemote {
    override suspend fun fetchMoviesFromGenre(genreId: String, page: Int): List<MovieDto> {
        return moviesApi.getMoviesFromGenre(genreId = genreId, page = page).results
    }

    override suspend fun fetchUpcomingMovies(page: Int): List<MovieDto> {
        return moviesApi.fetchUpComingMovies(page = page).results
    }
}
