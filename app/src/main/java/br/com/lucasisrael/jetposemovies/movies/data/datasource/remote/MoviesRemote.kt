package br.com.lucasisrael.jetposemovies.movies.data.datasource.remote

import br.com.lucasisrael.jetposemovies.movies.data.models.remote.MovieDto

interface MoviesRemote {

    @SuppressWarnings("LongParameterList")
    suspend fun fetchMovies(
        genreId: String?,
        sortBy: String?,
        releaseType: Int?,
        releaseDateGte: String?,
        releaseDateLte: String?,
        page: Int?
    ): List<MovieDto>
}
