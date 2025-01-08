package br.com.lucasisrael.jetposemovies.movies.models.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "popular",
    foreignKeys = [
        ForeignKey(
            entity = MovieEntity::class,
            parentColumns = ["id"],
            childColumns = ["movie_id"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index("movie_id")]
)
data class PopularMoviesEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("table_id")
    val tableId: Int,
    @ColumnInfo("movie_id")
    val movieId: Int?,
)
