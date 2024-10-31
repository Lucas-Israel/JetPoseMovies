package br.com.lucasisrael.jetposemovies.movies.data.models.response

import br.com.lucasisrael.jetposemovies.movies.data.models.remote.MovieDto


data class MoviesResponse(
    val page: Int,
    val results: List<MovieDto>,
    val totalPages: Int,
    val totalResults: Int
)
