package br.com.lucasisrael.jetposemovies.details.data.mappers

import br.com.lucasisrael.jetposemovies.details.models.domain.DetailsDomain
import br.com.lucasisrael.jetposemovies.details.models.local.DetailsEntity
import br.com.lucasisrael.jetposemovies.details.models.remote.DetailsDto
import br.com.lucasisrael.jetposemovies.genres.data.mappers.toDomain
import br.com.lucasisrael.jetposemovies.genres.data.mappers.toEntity

fun DetailsDto.toEntity(): DetailsEntity {
    return DetailsEntity(
        backdropPath = backdropPath,
        genres = genres?.map { it.toEntity() },
        homepage = homepage,
        id = id,
        overview = overview,
        popularity = popularity,
        posterPath = posterPath,
        releaseDate = releaseDate,
        runtime = runtime,
        tagline = tagline,
        title = title,
        voteAverage = voteAverage,
        voteCount = voteCount,
        videos = videos.results
    )
}

fun DetailsEntity.toDomain(): DetailsDomain {
    return DetailsDomain(
        backdropPath = backdropPath,
        genres = genres?.map { it.toDomain() },
        homepage = homepage,
        id = id,
        overview = overview,
        popularity = popularity,
        posterPath = posterPath,
        releaseDate = releaseDate,
        runtime = runtime,
        tagline = tagline,
        title = title,
        voteAverage = voteAverage,
        voteCount = voteCount,
        videos = videos.sortedByDescending { it.type == "Clip" || it.type == "Trailer" }
    )
}
