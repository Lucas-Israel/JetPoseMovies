package br.com.lucasisrael.jetposemovies.moviesList.data.models.response

import br.com.lucasisrael.jetposemovies.common.models.Movie


data class MoviesListResponse(
    val page: Int,
    val results: List<Movie>,
    val totalPages: Int,
    val totalResults: Int
)
