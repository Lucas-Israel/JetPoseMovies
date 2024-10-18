package br.com.lucasisrael.jetposemovies.moviesgenre.domain.models

import br.com.lucasisrael.jetposemovies.common.models.Movie

data class MoviesFromGenre(
    val page: Int,
    val results: List<Movie>,
    val totalPages: Int,
    val totalResults: Int
)
