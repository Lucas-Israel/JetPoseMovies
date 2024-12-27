package br.com.lucasisrael.jetposemovies.details.models.domain

import br.com.lucasisrael.jetposemovies.details.models.local.ISOCountry
import br.com.lucasisrael.jetposemovies.details.models.local.MovieCollectionEntity
import br.com.lucasisrael.jetposemovies.details.models.local.ProductionCompany
import br.com.lucasisrael.jetposemovies.details.models.local.SpokenLanguages
import br.com.lucasisrael.jetposemovies.genres.models.domain.GenreDomain

data class DetailsDomain (
    val detailsId: Int?,
    val adult: Boolean?,
    val backdropPath: String?,
    val belongsToCollection: MovieCollectionEntity?,
    val budget: Int?,
    val genres: List<GenreDomain>?,
    val homepage: String?,
    val id: Int?,
    val imdbId: String?,
    val originCountry: List<String>?,
    val originalLanguage: String?,
    val originalTitle: String?,
    val overview: String?,
    val popularity: Double?,
    val posterPath: String?,
    val productionCompanies: List<ProductionCompany>?,
    val productionCountries: List<ISOCountry>?,
    val releaseDate: String?,
    val revenue: Long?,
    val runtime: Int?,
    val spokenLanguages: List<SpokenLanguages>?,
    val status: String?,
    val tagline: String?,
    val title: String?,
    val video: Boolean?,
    val voteAverage: Double?,
    val voteCount: Int?,
)
