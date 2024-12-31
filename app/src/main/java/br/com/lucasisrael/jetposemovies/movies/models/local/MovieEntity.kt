package br.com.lucasisrael.jetposemovies.movies.models.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters

@Entity(tableName = "movies")
data class MovieEntity(
    @PrimaryKey
    val id: Int?,
    val overview: String?,
    @ColumnInfo("release_date")
    val releaseDate: String?,
    val title: String?,
    @ColumnInfo("poster_path")
    val posterPath: String?,
)
