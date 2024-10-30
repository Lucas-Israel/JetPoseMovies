package br.com.lucasisrael.jetposemovies.moviesList.domain.models

import br.com.lucasisrael.jetposemovies.common.models.Movie

data class MoviesList(
    val page: Int,
    val results: List<Movie>,
    val totalPages: Int,
    val totalResults: Int
)
