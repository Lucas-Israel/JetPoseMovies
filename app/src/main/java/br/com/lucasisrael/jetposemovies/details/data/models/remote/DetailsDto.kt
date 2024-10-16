package br.com.lucasisrael.jetposemovies.details.data.models.remote

import br.com.lucasisrael.jetposemovies.common.models.ISOCountry
import br.com.lucasisrael.jetposemovies.common.models.MovieCollection
import br.com.lucasisrael.jetposemovies.common.models.ProductionCompany
import br.com.lucasisrael.jetposemovies.common.models.SpokenLanguages
import br.com.lucasisrael.jetposemovies.genres.data.models.local.GenreEntity
import br.com.lucasisrael.jetposemovies.genres.data.models.remote.GenreDto

data class DetailsDto(
    val adult: Boolean,
    val backdropPath: String,
    val belongsToCollection: MovieCollection,
    val budget: Int,
    val genres: List<GenreDto>,
    val homepage: String,
    val id: Int,
    val imdbId: String,
    val originCountry: List<String>,
    val originalLanguage: String,
    val originalTitle: String,
    val overview: String,
    val popularity: Double,
    val posterPath: String,
    val productionCompanies: List<ProductionCompany>,
    val productionCountries: List<ISOCountry>,
    val releaseDate: String,
    val revenue: Long,
    val runtime: Int,
    val spokenLanguages: List<SpokenLanguages>,
    val status: String,
    val tagline: String,
    val title: String,
    val video: Boolean,
    val voteAverage: Double,
    val voteCount: Int,
)
