package br.com.lucasisrael.jetposemovies.common.models

import androidx.room.ColumnInfo

data class MovieCollection(
    val id: Int,
    val name: String,
    @ColumnInfo(name = "poster_path")
    val posterPath: String,
    @ColumnInfo(name = "backdrop_path")
    val backdropPath: String
)
