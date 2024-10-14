package br.com.lucasisrael.jetposemovies.details.data.models.local

import androidx.room.Entity
import br.com.lucasisrael.jetposemovies.common.models.ISOCountry
import br.com.lucasisrael.jetposemovies.common.models.MovieCollection
import br.com.lucasisrael.jetposemovies.common.models.ProductionCompany
import br.com.lucasisrael.jetposemovies.common.models.SpokenLanguages
import br.com.lucasisrael.jetposemovies.genres.data.models.domain.Genre

@Entity
data class DetailsEntity(
    val adult: Boolean,
    val backdrop_path: String,
    val belongs_to_collection: MovieCollection,
    val budget: Int,
    val genres: List<Genre>,
    val homepage: String,
    val id: Int,
    val imdb_id: String,
    val origin_country: String,
    val original_language: String,
    val original_title: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    val production_companies: List<ProductionCompany>,
    val production_countries: List<ISOCountry>,
    val release_date: String,
    val revenue: Int,
    val runtime: Int,
    val spoken_languages: List<SpokenLanguages>,
    val status: String,
    val tagline: String,
    val title: String,
    val video: Boolean,
    val vote_average: Double,
    val vote_count: Int,
)
