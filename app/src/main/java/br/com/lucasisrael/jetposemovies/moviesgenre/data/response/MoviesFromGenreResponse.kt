package br.com.lucasisrael.jetposemovies.moviesgenre.data.response


data class MoviesFromGenreResponse(
    val page: Int,
    val results: List<MoviesFromGenreResult>,
    val total_pages: Int,
    val total_results: Int
)
