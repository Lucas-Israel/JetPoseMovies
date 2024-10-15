package br.com.lucasisrael.jetposemovies.common.models

import androidx.room.ColumnInfo

data class SpokenLanguages(
    @ColumnInfo(name = "english_name")
    val englishName: String,
    @ColumnInfo(name = "iso_639_1")
    val iso6391: String,
    val name: String,
)
