package br.com.lucasisrael.jetposemovies.moviesgenre.data.models.response

import br.com.lucasisrael.jetposemovies.moviesgenre.data.models.remote.MovieFromGenreDto

data class MoviesFromGenreResponse(
    val page: Int,
    val results: List<MovieFromGenreDto>,
    val total_pages: Int,
    val total_results: Int
)
