package br.com.lucasisrael.jetposemovies.details.data.models.domain

import br.com.lucasisrael.jetposemovies.common.models.ISOCountry
import br.com.lucasisrael.jetposemovies.common.models.MovieCollection
import br.com.lucasisrael.jetposemovies.common.models.ProductionCompany
import br.com.lucasisrael.jetposemovies.common.models.SpokenLanguages
import br.com.lucasisrael.jetposemovies.genres.data.models.domain.Genre

data class Details (
    val adult: Boolean = false,
    val backdropPath: String = "",
    val belongsToCollection: MovieCollection = MovieCollection(),
    val budget: Int = 0,
    val genres: List<Genre> = listOf<Genre>(),
    val homepage: String = "",
    val id: Int = 0,
    val imdbId: String = "",
    val originCountry: List<String> = listOf(),
    val originalLanguage: String = "",
    val originalTitle: String = "",
    val overview: String = "",
    val popularity: Double = 0.00,
    val posterPath: String = "",
    val productionCompanies: List<ProductionCompany> = listOf<ProductionCompany>(),
    val productionCountries: List<ISOCountry> = listOf<ISOCountry>(),
    val releaseDate: String = "",
    val revenue: Long = 0L,
    val runtime: Int = 0,
    val spokenLanguages: List<SpokenLanguages> = listOf(),
    val status: String = "",
    val tagline: String = "",
    val title: String = "",
    val video: Boolean = false,
    val voteAverage: Double = 0.00,
    val voteCount: Int = 0,
)
