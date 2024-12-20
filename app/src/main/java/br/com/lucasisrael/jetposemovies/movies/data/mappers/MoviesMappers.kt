package br.com.lucasisrael.jetposemovies.movies.data.mappers

import br.com.lucasisrael.jetposemovies.movies.domain.models.MovieDomain
import br.com.lucasisrael.jetposemovies.movies.data.models.local.MovieEntity
import br.com.lucasisrael.jetposemovies.movies.data.models.local.NowPlayingMovieEntity
import br.com.lucasisrael.jetposemovies.movies.data.models.local.PopularMoviesEntity
import br.com.lucasisrael.jetposemovies.movies.data.models.local.TopRatedMoviesEntity
import br.com.lucasisrael.jetposemovies.movies.data.models.local.UpcomingMoviesEntity
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

fun MovieDto.toUpcomingMovieEntity(): UpcomingMoviesEntity {
    return UpcomingMoviesEntity(
        tableId = 0,
        movieId = id ?: 0
    )
}

fun MovieDto.toPopularMovieEntity(): PopularMoviesEntity {
    return PopularMoviesEntity(
        tableId = 0,
        movieId = id ?: 0
    )
}

fun MovieDto.toTopRatedMovieEntity(): TopRatedMoviesEntity {
    return TopRatedMoviesEntity(
        tableId = 0,
        movieId = id ?: 0
    )
}

fun MovieDto.toNowPlayingMovieEntity(): NowPlayingMovieEntity {
    return NowPlayingMovieEntity(
        tableId = 0,
        movieId = id ?: 0
    )
}
