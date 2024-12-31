package br.com.lucasisrael.jetposemovies.details.models.domain

import br.com.lucasisrael.jetposemovies.genres.models.domain.GenreDomain

data class DetailsDomain (
    val backdropPath: String?,
    val genres: List<GenreDomain>?,
    val homepage: String?,
    val id: Int?,
    val overview: String?,
    val popularity: Double?,
    val posterPath: String?,
    val releaseDate: String?,
    val runtime: Int?,
    val tagline: String?,
    val title: String?,
    val voteAverage: Double?,
    val voteCount: Int?,
)
