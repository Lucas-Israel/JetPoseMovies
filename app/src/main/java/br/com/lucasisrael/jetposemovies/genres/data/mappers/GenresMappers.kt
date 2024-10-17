package br.com.lucasisrael.jetposemovies.genres.data.mappers

import br.com.lucasisrael.jetposemovies.common.models.GenreWithImgUrl
import br.com.lucasisrael.jetposemovies.genres.data.models.domain.Genre
import br.com.lucasisrael.jetposemovies.genres.data.models.local.GenreEntity
import br.com.lucasisrael.jetposemovies.genres.data.models.remote.GenreDto
import br.com.lucasisrael.jetposemovies.genres.data.models.response.GenreResponse

fun GenreResponse.toGenreDto() : GenreDto {
    return GenreDto(
        id = id,
        name = name
    )
}

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

fun GenreEntity.toGenreWithUrl(imageUrl: String) : GenreWithImgUrl {
    return GenreWithImgUrl(
        id = id,
        name = name,
        imgUrl = imageUrl
    )
}
