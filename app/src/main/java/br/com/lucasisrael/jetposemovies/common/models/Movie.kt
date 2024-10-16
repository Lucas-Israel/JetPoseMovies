package br.com.lucasisrael.jetposemovies.common.models

import androidx.room.ColumnInfo
import com.google.gson.annotations.SerializedName

data class Movie(
    val adult: Boolean,
    @ColumnInfo(name = "backdrop_path")
    @SerializedName("backdrop_path")
    val backdropPath: String?,
    @ColumnInfo(name = "genre_ids")
    @SerializedName("genre_ids")
    val genreIds: List<Int>,
    val id: Int,
    @ColumnInfo(name = "original_language")
    @SerializedName("original_language")
    val originalLanguage: String,
    @ColumnInfo(name = "original_Title")
    @SerializedName("original_Title")
    val originalTitle: String,
    val overview: String,
    val popularity: Double,
    @ColumnInfo(name = "poster_path")
    @SerializedName("poster_path")
    val posterPath: String?,
    @ColumnInfo(name = "release_date")
    @SerializedName("release_date")
    val releaseDate: String,
    val title: String,
    val video: Boolean,
    @ColumnInfo(name = "vote_average")
    @SerializedName("vote_average")
    val voteAverage: Double,
    @ColumnInfo(name = "vote_count")
    @SerializedName("vote_count")
    val voteCount: Int
)
