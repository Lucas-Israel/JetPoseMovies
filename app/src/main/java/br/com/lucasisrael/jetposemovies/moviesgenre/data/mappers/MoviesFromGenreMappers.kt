package br.com.lucasisrael.jetposemovies.moviesgenre.data.mappers

import br.com.lucasisrael.jetposemovies.moviesgenre.data.models.domain.MoviesFromGenre
import br.com.lucasisrael.jetposemovies.moviesgenre.data.models.local.MoviesFromGenreEntity
import br.com.lucasisrael.jetposemovies.moviesgenre.data.models.remote.MoviesFromGenreDto

fun MoviesFromGenreDto.toMoviesFromGenreEntity(): MoviesFromGenreEntity {
    return MoviesFromGenreEntity(
        page, results, total_pages, total_results
    )
}

fun MoviesFromGenreEntity.toMoviesFromGenre(): MoviesFromGenre {
    return MoviesFromGenre(
        page, results, total_pages, total_results
    )
}
