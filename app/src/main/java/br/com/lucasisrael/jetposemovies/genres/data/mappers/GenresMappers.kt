package br.com.lucasisrael.jetposemovies.genres.data.mappers

import br.com.lucasisrael.jetposemovies.genres.data.models.domain.Genre
import br.com.lucasisrael.jetposemovies.genres.data.models.local.GenreEntity
import br.com.lucasisrael.jetposemovies.genres.data.models.remote.GenreDto

fun GenreDto.toGenresEntity() : GenreEntity {
    return GenreEntity(
        id = id,
        name = name
    )
}

fun GenreEntity.toGenres() : Genre {
    return Genre(
        id = id,
        name = name
    )
}
