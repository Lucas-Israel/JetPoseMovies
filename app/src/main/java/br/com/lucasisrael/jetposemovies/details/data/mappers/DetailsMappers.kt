package br.com.lucasisrael.jetposemovies.details.data.mappers

import br.com.lucasisrael.jetposemovies.common.models.MovieCollection
import br.com.lucasisrael.jetposemovies.details.data.models.domain.Details
import br.com.lucasisrael.jetposemovies.details.data.models.local.DetailsEntity
import br.com.lucasisrael.jetposemovies.details.data.models.remote.DetailsDto
import br.com.lucasisrael.jetposemovies.details.data.models.response.DetailsResponse
import br.com.lucasisrael.jetposemovies.genres.data.mappers.toGenres
import br.com.lucasisrael.jetposemovies.genres.data.mappers.toGenresEntity

fun DetailsResponse.toDetailsDto(): DetailsDto {
    return DetailsDto(
        adult = adult ?: false,
        backdropPath = backdropPath ?: "",
        belongsToCollection = belongsToCollection ?: MovieCollection(),
        budget = budget ?: 0,
        genres = genres ?: listOf(),
        homepage = homepage ?: "",
        id = id ?: 0,
        imdbId = imdbId ?: "",
        originCountry = originCountry ?: listOf(),
        originalLanguage = originalLanguage ?: "",
        originalTitle = originalTitle ?: "",
        overview = overview ?: "",
        popularity = popularity ?: 0.00,
        posterPath = posterPath ?: "",
        productionCompanies = productionCompanies ?: listOf(),
        productionCountries = productionCountries ?: listOf(),
        releaseDate = releaseDate ?: "",
        revenue = revenue ?: 0L,
        runtime = runtime ?: 0,
        spokenLanguages = spokenLanguages ?: listOf(),
        status = status ?: "",
        tagline = tagline ?: "",
        title = title ?: "",
        video = video ?: false,
        voteAverage = voteAverage ?: 0.00,
        voteCount = voteCount ?: 0
    )
}

fun DetailsDto.toDetailsEntity(): DetailsEntity {
    return DetailsEntity(
        detailsId = 0,
        adult,
        backdropPath,
        belongsToCollection,
        budget,
        genres = genres.map { it.toGenresEntity() },
        homepage,
        id,
        imdbId,
        originCountry,
        originalLanguage,
        originalTitle,
        overview,
        popularity,
        posterPath,
        productionCompanies,
        productionCountries,
        releaseDate,
        revenue,
        runtime,
        spokenLanguages,
        status,
        tagline,
        title,
        video,
        voteAverage,
        voteCount
    )
}

fun DetailsEntity.toDetails(): Details {
    return Details(
        adult,
        backdropPath,
        belongsToCollection,
        budget,
        genres = genres.map { it.toGenres() },
        homepage,
        id,
        imdbId,
        originCountry,
        originalLanguage,
        originalTitle,
        overview,
        popularity,
        posterPath,
        productionCompanies,
        productionCountries,
        releaseDate,
        revenue,
        runtime,
        spokenLanguages,
        status,
        tagline,
        title,
        video,
        voteAverage,
        voteCount
    )
}
