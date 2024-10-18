package br.com.lucasisrael.jetposemovies.genres.data.models.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "genre_entity")
data class GenreEntity(
    @PrimaryKey
    val id: Int,
    val name: String
)
