package br.com.lucasisrael.jetposemovies.movies.data.datasource.remote

import br.com.lucasisrael.jetposemovies.movies.data.models.query.MovieApiQuery
import br.com.lucasisrael.jetposemovies.movies.data.models.remote.MovieDto

interface MoviesRemote {

    @SuppressWarnings("LongParameterList")
    suspend fun fetchMovies(query: MovieApiQuery): List<MovieDto>
}
