package br.com.lucasisrael.jetposemovies.moviesgenre.data.respose

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.JsonNames

data class MoviesFromGenreResponse @OptIn(ExperimentalSerializationApi::class) constructor(
    val page: Int,
    val results: MoviesFromGenreResult,
    @JsonNames("total_pages")
    val totalPages: Int,
    @JsonNames("total_results")
    val totalResults: Int
)
