package br.com.lucasisrael.jetposemovies.common.models

import androidx.room.ColumnInfo
import com.google.gson.annotations.SerializedName

data class SpokenLanguages(
    @SerializedName("english_name")
    val englishName: String,
    @SerializedName("iso_639_1")
    val iso6391: String,
    val name: String,
)
