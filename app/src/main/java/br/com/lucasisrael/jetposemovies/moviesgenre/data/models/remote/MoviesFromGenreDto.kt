package br.com.lucasisrael.jetposemovies.moviesgenre.data.models.remote

import br.com.lucasisrael.jetposemovies.common.models.Movie

data class MoviesFromGenreDto(
    val page: Int,
    val results: List<Movie>,
    val total_pages: Int,
    val total_results: Int
)
