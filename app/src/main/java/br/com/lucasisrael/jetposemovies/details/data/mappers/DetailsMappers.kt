package br.com.lucasisrael.jetposemovies.details.data.mappers

import br.com.lucasisrael.jetposemovies.details.models.domain.DetailsDomain
import br.com.lucasisrael.jetposemovies.details.models.local.DetailsEntity
import br.com.lucasisrael.jetposemovies.details.models.remote.DetailsDto
import br.com.lucasisrael.jetposemovies.genres.data.mappers.toDomain
import br.com.lucasisrael.jetposemovies.genres.data.mappers.toEntity

fun DetailsDto.toDetailsEntity(): DetailsEntity {
    return DetailsEntity(
        detailsId = 0,
        adult = adult,
        backdropPath = backdropPath,
        belongsToCollection = belongsToCollection,
        budget = budget,
        genres = genres?.map { it.toEntity() },
        homepage = homepage,
        id = id,
        imdbId = imdbId,
        originCountry = originCountry,
        originalLanguage = originalLanguage,
        originalTitle = originalTitle,
        overview = overview,
        popularity = popularity,
        posterPath = posterPath,
        productionCompanies = productionCompanies,
        productionCountries = productionCountries,
        releaseDate = releaseDate,
        revenue = revenue,
        runtime = runtime,
        spokenLanguages = spokenLanguages,
        status = status,
        tagline = tagline,
        title = title,
        video = video,
        voteAverage = voteAverage,
        voteCount = voteCount
    )
}

fun DetailsEntity.toDomain(): DetailsDomain {
    return DetailsDomain(
        detailsId = 0,
        adult = adult,
        backdropPath = backdropPath,
        belongsToCollection = belongsToCollection,
        budget = budget,
        genres = genres?.map { it.toDomain() },
        homepage = homepage,
        id = id,
        imdbId = imdbId,
        originCountry = originCountry,
        originalLanguage = originalLanguage,
        originalTitle = originalTitle,
        overview = overview,
        popularity = popularity,
        posterPath = posterPath,
        productionCompanies = productionCompanies,
        productionCountries = productionCountries,
        releaseDate = releaseDate,
        revenue = revenue,
        runtime = runtime,
        spokenLanguages = spokenLanguages,
        status = status,
        tagline = tagline,
        title = title,
        video = video,
        voteAverage = voteAverage,
        voteCount = voteCount
    )
}
