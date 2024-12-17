package br.com.lucasisrael.jetposemovies.movies.data.models.local

import androidx.room.Embedded
import androidx.room.Relation

data class UpcomingWithMovie(
    @Embedded val upcomingMovie: UpcomingMoviesEntity,
    @Relation(
        parentColumn = "movieId",
        entityColumn = "id"
    )
    val movie: MovieEntity
)
