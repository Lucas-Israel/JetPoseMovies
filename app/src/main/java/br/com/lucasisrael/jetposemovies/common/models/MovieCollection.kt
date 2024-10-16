package br.com.lucasisrael.jetposemovies.common.models

import com.google.gson.annotations.SerializedName

data class MovieCollection(
    val id: Int = 0,
    val name: String = "",
    @SerializedName("poster_path")
    val posterPath: String = "",
    @SerializedName("backdrop_path")
    val backdropPath: String = ""
)
