package br.com.lucasisrael.jetposemovies.common.models

import androidx.room.ColumnInfo
import com.google.gson.annotations.SerializedName

data class ISOCountry(
    @SerializedName("iso_3166_1")
    val iso3166u1: String,
    val name: String,
)
