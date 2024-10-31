package br.com.lucasisrael.jetposemovies.movies.data.models.response

import br.com.lucasisrael.jetposemovies.movies.data.models.remote.MovieDto

data class MoviesListIUpcomingResponse(
    val dates: dates,
    val page: Int,
    val results: List<MovieDto>,
    val totalPages: Int,
    val totalResults: Int
)

data class dates(
    val maximum: String,
    val minimum: String
)