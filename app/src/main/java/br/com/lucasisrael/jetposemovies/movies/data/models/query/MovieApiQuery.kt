package br.com.lucasisrael.jetposemovies.movies.data.models.query

data class MovieApiQuery(
    val genreId: String? = null,
    val sortBy: String? = "popularity.desc",
    val releaseType: Int? = null,
    val releaseDateGte: String? = null,
    val releaseDateLte: String? = null,
    val page: Int? = 1
)
