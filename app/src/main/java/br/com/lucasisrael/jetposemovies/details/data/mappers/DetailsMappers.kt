package br.com.lucasisrael.jetposemovies.details.data.mappers

import br.com.lucasisrael.jetposemovies.details.data.models.remote.DetailsDto
import br.com.lucasisrael.jetposemovies.details.data.models.response.DetailsResponse

fun DetailsResponse.toDetailsDto(): DetailsDto {
    return DetailsDto(
        adult,
        backdrop_path,
        belongs_to_collection,
        budget,
        genres,
        homepage,
        id,
        imdb_id,
        origin_country,
        original_language,
        original_title,
        overview,
        popularity,
        poster_path,
        production_companies,
        production_countries,
        release_date,
        revenue,
        runtime,
        spoken_languages,
        status,
        tagline,
        title,
        video,
        vote_average,
        vote_count
    )
}
