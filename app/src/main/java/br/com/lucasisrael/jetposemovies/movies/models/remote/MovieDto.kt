package br.com.lucasisrael.jetposemovies.movies.models.remote

import com.google.gson.annotations.SerializedName

data class MovieDto(
    @SerializedName("genre_ids")
    val genreIds: List<Int>?,
    val id: Int?,
    val overview: String?,
    @SerializedName("release_date")
    val releaseDate: String?,
    val title: String?,
    @SerializedName("poster_path")
    val posterPath: String?,
)
