package br.com.lucasisrael.jetposemovies.details.models.local

import com.google.gson.annotations.SerializedName

data class MovieCollection(
    val id: Int?,
    val name: String?,
    @SerializedName("poster_path")
    val posterPath: String?,
    @SerializedName("backdrop_path")
    val backdropPath: String?
)
