package br.com.lucasisrael.jetposemovies.moviesgenre.data.respose

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.JsonNames

data class MoviesFromGenreResult(
    val adult: Boolean,
    val backdrop_path: String,
    val genre_ids: List<Int>,
    val id: Int,
    val original_language: String,
    val original_Title: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    val release_date: String,
    val title: String,
    val video: Boolean,
    val vote_average: Double,
    val vote_count: Int
)
