package br.com.lucasisrael.jetposemovies.movies.models.local

import androidx.room.Embedded
import androidx.room.Relation

data class PopularWithMovie(
    @Embedded val popularMovie: PopularMoviesEntity,
    @Relation(
        parentColumn = "movieId",
        entityColumn = "id"
    )
    val movie: MovieEntity
)
