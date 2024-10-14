package br.com.lucasisrael.jetposemovies.moviesgenre.data.models.domain

import br.com.lucasisrael.jetposemovies.common.models.Movie

data class MoviesFromGenre(
    val page: Int,
    val results: List<Movie>,
    val total_pages: Int,
    val total_results: Int
)
