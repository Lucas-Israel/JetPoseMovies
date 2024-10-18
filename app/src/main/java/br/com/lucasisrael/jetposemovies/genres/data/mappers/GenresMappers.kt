package br.com.lucasisrael.jetposemovies.genres.data.mappers

import br.com.lucasisrael.jetposemovies.common.utils.types.values.dephault.replaceNullable
import br.com.lucasisrael.jetposemovies.genres.domain.models.GenreWithImgUrl
import br.com.lucasisrael.jetposemovies.genres.data.models.local.GenreEntity
import br.com.lucasisrael.jetposemovies.genres.data.models.remote.GenreDto
import br.com.lucasisrael.jetposemovies.genres.domain.models.Genre

fun GenreDto.toGenresEntity() : GenreEntity {
    return GenreEntity(
        id.replaceNullable(),
        name.replaceNullable()
    )
}

fun GenreEntity.toGenres() : Genre {
    return Genre(
        id = id,
        name = name
    )
}

fun GenreEntity.toGenreWithUrl(imageUrl: String) : GenreWithImgUrl {
    return GenreWithImgUrl(
        id = id,
        name = name,
        imgUrl = imageUrl
    )
}
