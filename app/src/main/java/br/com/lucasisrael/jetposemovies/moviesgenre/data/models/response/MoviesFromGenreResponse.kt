package br.com.lucasisrael.jetposemovies.moviesgenre.data.models.response

import br.com.lucasisrael.jetposemovies.moviesgenre.data.models.remote.MoviesFromGenreDto


data class MoviesFromGenreResponse(
    val page: Int,
    val results: List<MoviesFromGenreDto>,
    val total_pages: Int,
    val total_results: Int
)
