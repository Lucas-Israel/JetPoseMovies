package br.com.lucasisrael.jetposemovies.details.data.models.response

import br.com.lucasisrael.jetposemovies.common.models.ISOCountry
import br.com.lucasisrael.jetposemovies.common.models.MovieCollection
import br.com.lucasisrael.jetposemovies.common.models.ProductionCompany
import br.com.lucasisrael.jetposemovies.common.models.SpokenLanguages
import br.com.lucasisrael.jetposemovies.genres.data.models.remote.GenreDto
import com.google.gson.annotations.SerializedName

data class DetailsResponse(
    val adult: Boolean?,
    @SerializedName("backdrop_path")
    val backdropPath: String?,
    @SerializedName("belongs_to_collection")
    val belongsToCollection: MovieCollection?,
    val budget: Int?,
    val genres: List<GenreDto>?,
    val homepage: String?,
    val id: Int?,
    @SerializedName("imdb_id")
    val imdbId: String?,
    @SerializedName("origin_country")
    val originCountry: List<String>?,
    @SerializedName("original_language")
    val originalLanguage: String?,
    @SerializedName("original_title")
    val originalTitle: String?,
    val overview: String?,
    val popularity: Double?,
    @SerializedName("poster_path")
    val posterPath: String?,
    @SerializedName("production_companies")
    val productionCompanies: List<ProductionCompany>?,
    @SerializedName("production_countries")
    val productionCountries: List<ISOCountry>?,
    @SerializedName("release_date")
    val releaseDate: String?,
    val revenue: Long?,
    val runtime: Int?,
    @SerializedName("spoken_languages")
    val spokenLanguages: List<SpokenLanguages>?,
    val status: String?,
    val tagline: String?,
    val title: String?,
    val video: Boolean?,
    @SerializedName("vote_average")
    val voteAverage: Double?,
    @SerializedName("vote_count")
    val voteCount: Int?,
)
