package br.com.lucasisrael.jetposemovies.movies.data.datasource.remote

import br.com.lucasisrael.jetposemovies.movies.data.api.MoviesApi
import br.com.lucasisrael.jetposemovies.movies.data.models.query.MovieApiQuery
import br.com.lucasisrael.jetposemovies.movies.data.models.remote.MovieDto
import br.com.lucasisrael.jetposemovies.movies.data.models.response.MoviesResponse
import javax.inject.Inject

class MoviesRemoteImpl @Inject constructor(
    private val moviesApi: MoviesApi,
) : MoviesRemote {
    override suspend fun fetchMovies(query: MovieApiQuery): MoviesResponse {
        return moviesApi.fetchMovies(
            releaseType = query.releaseType,
            page = query.page,
            sortBy = query.sortBy,
            genreId = query.genreId,
            releaseDateGte = query.releaseDateGte,
            releaseDateLte = query.releaseDateLte,
        )
    }

}
