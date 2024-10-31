package br.com.lucasisrael.jetposemovies.movies.data.mappers

import br.com.lucasisrael.jetposemovies.movies.domain.models.MovieDomain
import br.com.lucasisrael.jetposemovies.movies.data.models.local.MovieEntity
import br.com.lucasisrael.jetposemovies.movies.data.models.remote.MovieDto

fun MovieDto.toMoviesListEntity(): MovieEntity {
    return MovieEntity(
        adult,
        posterPath,
        genreIds,
        id,
        originalTitle,
        title,
        overview,
        popularity,
        posterPath,
        releaseDate,
        originalTitle,
        video,
        voteAverage,
        voteCount,
    )
}

fun MovieEntity.toMovieDomain(): MovieDomain {
    return MovieDomain(
        adult,
        posterPath,
        genreIds,
        id,
        originalTitle,
        title,
        overview,
        popularity,
        posterPath,
        releaseDate,
        originalTitle,
        video,
        voteAverage,
        voteCount,
    )
}
