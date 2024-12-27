package br.com.lucasisrael.jetposemovies.details.models.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index

@Entity(
    tableName = "movie_collections",
    primaryKeys = ["detail_id", "id"],
    indices = [Index("detail_id"), Index("id")]
)
data class MovieCollectionEntity(
    @ColumnInfo("detail_id")
    val detailId: Int,
    val id: Int?,
    val name: String?,
    @ColumnInfo("poster_path")
    val posterPath: String?,
    @ColumnInfo("backdrop_path")
    val backdropPath: String?,
)
