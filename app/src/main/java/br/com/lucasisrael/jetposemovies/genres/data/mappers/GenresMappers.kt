package br.com.lucasisrael.jetposemovies.genres.data.mappers

import br.com.lucasisrael.jetposemovies.genres.data.models.local.GenreEntity
import br.com.lucasisrael.jetposemovies.genres.data.models.remote.GenreDto
import br.com.lucasisrael.jetposemovies.genres.domain.models.GenreDomain

fun GenreDto.toEntity() : GenreEntity {
    return GenreEntity(
        id,
        name
    )
}

fun GenreEntity.toDomain() : GenreDomain {
    return GenreDomain(
        id = id,
        name = name
    )
}
