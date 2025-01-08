package br.com.lucasisrael.jetposemovies.movies.models.local

import androidx.room.Embedded
import androidx.room.Relation

data class UpcomingWithMovie(
    @Embedded val upcomingMovie: UpcomingMoviesEntity,
    @Relation(
        parentColumn = "movie_id",
        entityColumn = "id"
    )
    val movie: MovieEntity
)
