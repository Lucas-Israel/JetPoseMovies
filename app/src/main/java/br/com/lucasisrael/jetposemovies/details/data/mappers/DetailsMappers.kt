package br.com.lucasisrael.jetposemovies.details.data.mappers

import br.com.lucasisrael.jetposemovies.common.utils.types.values.dephault.replaceNullable
import br.com.lucasisrael.jetposemovies.details.data.models.domain.Details
import br.com.lucasisrael.jetposemovies.details.data.models.local.DetailsEntity
import br.com.lucasisrael.jetposemovies.details.data.models.remote.DetailsDto
import br.com.lucasisrael.jetposemovies.details.data.models.response.DetailsResponse
import br.com.lucasisrael.jetposemovies.genres.data.mappers.toGenres
import br.com.lucasisrael.jetposemovies.genres.data.mappers.toGenresEntity


fun DetailsResponse.toDetailsDto(): DetailsDto {
    return DetailsDto(
        adult.replaceNullable(),
        backdropPath.replaceNullable(),
        belongsToCollection.replaceNullable(),
        budget.replaceNullable(),
        genres.replaceNullable(),
        homepage.replaceNullable(),
        id.replaceNullable(),
        imdbId.replaceNullable(),
        originCountry.replaceNullable(),
        originalLanguage.replaceNullable(),
        originalTitle.replaceNullable(),
        overview.replaceNullable(),
        popularity.replaceNullable(),
        posterPath.replaceNullable(),
        productionCompanies.replaceNullable(),
        productionCountries.replaceNullable(),
        releaseDate.replaceNullable(),
        revenue.replaceNullable(),
        runtime.replaceNullable(),
        spokenLanguages.replaceNullable(),
        status.replaceNullable(),
        tagline.replaceNullable(),
        title.replaceNullable(),
        video.replaceNullable(),
        voteAverage.replaceNullable(),
        voteCount.replaceNullable()
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
