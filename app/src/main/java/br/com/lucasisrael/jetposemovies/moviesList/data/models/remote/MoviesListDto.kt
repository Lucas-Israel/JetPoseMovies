package br.com.lucasisrael.jetposemovies.moviesList.data.models.remote

import br.com.lucasisrael.jetposemovies.common.models.Movie

data class MoviesListDto(
    val page: Int,
    val results: List<Movie>,
    val totalPages: Int,
    val totalResults: Int
)
