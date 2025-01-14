package br.com.lucasisrael.jetposemovies.details.models.remote

import br.com.lucasisrael.jetposemovies.genres.models.remote.GenreDto
import com.google.gson.annotations.SerializedName

data class DetailsDto(
    @SerializedName("backdrop_path")
    val backdropPath: String?,
    val genres: List<GenreDto>?,
    val homepage: String?,
    val id: Int?,
    val overview: String?,
    val popularity: Double?,
    @SerializedName("poster_path")
    val posterPath: String?,
    @SerializedName("release_date")
    val releaseDate: String?,
    val runtime: Int?,
    val tagline: String?,
    val title: String?,
    @SerializedName("vote_average")
    val voteAverage: Double?,
    @SerializedName("vote_count")
    val voteCount: Int?,
    val videos: VideosResponse
)
