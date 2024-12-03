package br.com.lucasisrael.jetposemovies.common.utils.types

sealed class SearchType {
    data class GenreId(val genreId: String, val page: Int) : SearchType()
    data class Upcoming(val page: Int) : SearchType()
    data class Popular(val page: Int) : SearchType()
}
