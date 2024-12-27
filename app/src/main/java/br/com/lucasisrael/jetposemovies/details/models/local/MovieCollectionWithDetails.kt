package br.com.lucasisrael.jetposemovies.details.models.local

import androidx.room.Embedded
import androidx.room.Relation

data class MovieCollectionWithDetails(
    @Embedded
    val movieCollectionEntity: MovieCollectionEntity,
    @Relation(
        parentColumn = "detail_id",
        entityColumn = "id"
    )
    val detail: DetailsEntity,
)
