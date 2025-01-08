package br.com.lucasisrael.jetposemovies.movies.models.local

import androidx.room.Embedded
import androidx.room.Relation

data class PopularWithMovie(
    @Embedded val popularMovie: PopularMoviesEntity,
    @Relation(
        parentColumn = "movie_id",
        entityColumn = "id"
    )
    val movie: MovieEntity
)
