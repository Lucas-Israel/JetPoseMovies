package br.com.lucasisrael.jetposemovies.moviesList.data.mappers

import br.com.lucasisrael.jetposemovies.moviesList.domain.models.MoviesList
import br.com.lucasisrael.jetposemovies.moviesList.data.models.local.MoviesListEntity
import br.com.lucasisrael.jetposemovies.moviesList.data.models.remote.MoviesListDto
import br.com.lucasisrael.jetposemovies.moviesList.data.models.response.MoviesListResponse

fun MoviesListResponse.toMoviesFromGenreDto(): MoviesListDto {
    return MoviesListDto(
        page, results, totalPages, totalResults
    )
}

fun MoviesListDto.toMoviesFromGenreEntity(): MoviesListEntity {
    return MoviesListEntity(
        page, page, results, totalPages, totalResults
    )
}

fun MoviesListEntity.toMoviesFromGenre(): MoviesList {
    return MoviesList(
        page, results, totalPages, totalResults
    )
}
