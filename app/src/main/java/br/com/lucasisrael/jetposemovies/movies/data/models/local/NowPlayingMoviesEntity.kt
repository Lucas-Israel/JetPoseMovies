package br.com.lucasisrael.jetposemovies.movies.data.models.local

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "now_playing",
    foreignKeys = [
        ForeignKey(
            entity = MovieEntity::class,
            parentColumns = ["id"],
            childColumns = ["movieId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index("movieId")]
)
data class NowPlayingMoviesEntity(
    @PrimaryKey(autoGenerate = true) val tableId: Int,
    val movieId: Int?,
)
