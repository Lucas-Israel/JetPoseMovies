package br.com.lucasisrael.jetposemovies.movies.data.models.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import br.com.lucasisrael.jetposemovies.common.converters.ListConverters

@Entity(tableName = "movies_from_genre")
@TypeConverters(
    ListConverters::class
)
data class MovieEntity(
    val adult: Boolean?,
    @ColumnInfo("backdrop_path")
    val backdropPath: String?,
    @ColumnInfo("genre_ids")
    val genreIds: List<Int>?,
    @PrimaryKey
    val id: Int?,
    @ColumnInfo("original_language")
    val originalLanguage: String?,
    @ColumnInfo("original_title")
    val originalTitle: String?,
    val overview: String?,
    val popularity: Double?,
    @ColumnInfo("poster_path")
    val posterPath: String?,
    @ColumnInfo("release_date")
    val releaseDate: String?,
    val title: String?,
    val video: Boolean?,
    @ColumnInfo("vote_average")
    val voteAverage: Double?,
    @ColumnInfo("vote_count")
    val voteCount: Int?
)
