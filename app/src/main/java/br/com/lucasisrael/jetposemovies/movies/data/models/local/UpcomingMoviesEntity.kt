package br.com.lucasisrael.jetposemovies.movies.data.models.local

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "upcoming",
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
data class UpcomingMoviesEntity(
    @PrimaryKey(autoGenerate = true) val tableId: Int,
    val movieId: Int?,
)
