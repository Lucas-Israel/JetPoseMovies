package br.com.lucasisrael.jetposemovies.moviesgenre.data.respose

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.JsonNames

data class MoviesFromGenreResult @OptIn(ExperimentalSerializationApi::class) constructor(
    val adult: Boolean,
    @JsonNames("backdrop_path")
    val backdropPath: String,
    @JsonNames("genre_ids")
    val genreIds: List<Int>,
    val id: Int,
    @JsonNames("original_language")
    val originalLanguage: String,
    @JsonNames("original_Title")
    val originalTitle: String,
    val overview: String,
    val popularity: Double,
    @JsonNames("poster_path")
    val posterPath: String,
    @JsonNames("release_date")
    val releaseDate: String,
    val title: String,
    val video: Boolean,
    @JsonNames("vote_average")
    val voteAverage: Double,
    @JsonNames("vote_count")
    val voteCount: Int
)
