package br.com.lucasisrael.jetposemovies.moviesgenre.data.models.response

import br.com.lucasisrael.jetposemovies.common.models.Movie


data class MoviesFromGenreResponse(
    val page: Int,
    val results: List<Movie>,
    val totalPages: Int,
    val totalResults: Int
)
