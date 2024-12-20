package br.com.lucasisrael.jetposemovies.movies.data.models.local

import androidx.room.Embedded
import androidx.room.Relation

data class NowPlayingWithMovie(
    @Embedded val nowPlayingMovie: NowPlayingMovieEntity,
    @Relation(
        parentColumn = "movieId",
        entityColumn = "id"
    )
    val movie: MovieEntity
)
