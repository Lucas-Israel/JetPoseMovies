package br.com.lucasisrael.jetposemovies.common.models

import androidx.room.ColumnInfo

data class ISOCountry(
    @ColumnInfo(name = "iso_3166_1")
    val iso3166u1: String,
    val name: String,
)
