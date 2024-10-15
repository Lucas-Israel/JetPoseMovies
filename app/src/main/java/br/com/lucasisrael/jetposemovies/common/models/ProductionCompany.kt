package br.com.lucasisrael.jetposemovies.common.models

import androidx.room.ColumnInfo

data class ProductionCompany(
    val id: Int,
    @ColumnInfo(name = "logo_path")
    val logoPath: String,
    val name: String,
    @ColumnInfo(name = "origin_country")
    val originCountry: String
)
