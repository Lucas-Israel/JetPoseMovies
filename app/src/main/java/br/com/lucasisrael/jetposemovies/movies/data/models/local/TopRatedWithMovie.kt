package br.com.lucasisrael.jetposemovies.movies.data.models.local

import androidx.room.Embedded
import androidx.room.Relation

data class TopRatedWithMovie(
    @Embedded val topRatedMovie: TopRatedMoviesEntity,
    @Relation(
        parentColumn = "movieId",
        entityColumn = "id"
    )
    val movie: MovieEntity,
)
