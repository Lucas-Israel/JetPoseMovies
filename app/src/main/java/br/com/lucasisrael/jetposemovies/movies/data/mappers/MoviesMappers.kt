package br.com.lucasisrael.jetposemovies.movies.data.mappers

import br.com.lucasisrael.jetposemovies.movies.models.domain.MovieDomain
import br.com.lucasisrael.jetposemovies.movies.models.local.MovieEntity
import br.com.lucasisrael.jetposemovies.movies.models.local.MovieGenreIdsEntity
import br.com.lucasisrael.jetposemovies.movies.models.local.NowPlayingMovieEntity
import br.com.lucasisrael.jetposemovies.movies.models.local.PopularMoviesEntity
import br.com.lucasisrael.jetposemovies.movies.models.local.TopRatedMoviesEntity
import br.com.lucasisrael.jetposemovies.movies.models.local.UpcomingMoviesEntity
import br.com.lucasisrael.jetposemovies.movies.models.remote.MovieDto

fun MovieDto.toEntity(): MovieEntity {
    return MovieEntity(
        id = id,
        overview = overview,
        releaseDate = releaseDate,
        title = title,
        posterPath = posterPath
    )
}

fun MovieEntity.toDomain(): MovieDomain {
    return MovieDomain(
        id = id,
        overview = overview,
        releaseDate = releaseDate,
        title = title,
        posterPath = posterPath
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

fun MovieDto.toMovieGenreIdsEntityList(): List<MovieGenreIdsEntity> {
    return genreIds?.map { genreIds ->
        MovieGenreIdsEntity(
            movieId = id ?: 0,
            genreId = genreIds
        )
    } ?: emptyList()
}
