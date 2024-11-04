package br.com.lucasisrael.jetposemovies.movies.data.datasource.remote

import br.com.lucasisrael.jetposemovies.movies.data.api.MoviesApi
import br.com.lucasisrael.jetposemovies.movies.data.models.remote.MovieDto
import javax.inject.Inject

class MoviesRemoteImpl @Inject constructor(
    private val moviesApi: MoviesApi,
) : MoviesRemote {

    @SuppressWarnings("LongParameterList")
    override suspend fun fetchMovies(
        genreId: String?,
        sortBy: String?,
        releaseType: Int?,
        releaseDateGte: String?,
        releaseDateLte: String?,
        page: Int?
    ): List<MovieDto> {
        return moviesApi.fetchMovies(
            genreId = genreId,
            sortBy = sortBy,
            releaseType = releaseType,
            releaseDateGte = releaseDateGte,
            releaseDateLte = releaseDateLte,
            page = page
        ).results
    }
}
