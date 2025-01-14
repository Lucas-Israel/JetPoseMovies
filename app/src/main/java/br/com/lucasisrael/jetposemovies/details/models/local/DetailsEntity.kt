package br.com.lucasisrael.jetposemovies.details.models.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import br.com.lucasisrael.jetposemovies.details.models.remote.VideosItem
import br.com.lucasisrael.jetposemovies.genres.models.local.GenreEntity

@Entity(tableName = "details")
data class DetailsEntity(
    @ColumnInfo(name = "backdrop_path")
    val backdropPath: String?,
    val genres: List<GenreEntity>?,
    val homepage: String?,
    @PrimaryKey
    val id: Int?,
    val overview: String?,
    val popularity: Double?,
    @ColumnInfo(name = "poster_path")
    val posterPath: String?,
    @ColumnInfo(name = "release_date")
    val releaseDate: String?,
    val runtime: Int?,
    val tagline: String?,
    val title: String?,
    @ColumnInfo(name = "vote_average")
    val voteAverage: Double?,
    @ColumnInfo(name = "vote_count")
    val voteCount: Int?,
    val videos: List<VideosItem>
)
