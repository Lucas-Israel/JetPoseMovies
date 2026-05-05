package br.com.lucasisrael.jetposemovies.movies.models.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index

@Entity(
    tableName = "movie_genres_ids",
    primaryKeys = ["movie_id", "genre_id"],
    indices = [Index("genre_id")]
)
data class MovieGenreIdsEntity(
    @ColumnInfo("movie_id")
    val movieId: Int,
    @ColumnInfo("genre_id")
    val genreId: Int
)
