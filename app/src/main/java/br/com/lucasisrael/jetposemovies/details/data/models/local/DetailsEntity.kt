package br.com.lucasisrael.jetposemovies.details.data.models.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import br.com.lucasisrael.jetposemovies.common.converters.GenreConverters
import br.com.lucasisrael.jetposemovies.common.converters.ISOCountryConverters
import br.com.lucasisrael.jetposemovies.common.models.ISOCountry
import br.com.lucasisrael.jetposemovies.common.models.MovieCollection
import br.com.lucasisrael.jetposemovies.common.models.ProductionCompany
import br.com.lucasisrael.jetposemovies.common.models.SpokenLanguages
import br.com.lucasisrael.jetposemovies.common.converters.MovieCollectionConverters
import br.com.lucasisrael.jetposemovies.common.converters.ProductionCompanyConverters
import br.com.lucasisrael.jetposemovies.common.converters.SpokenLanguagesConverters
import br.com.lucasisrael.jetposemovies.genres.data.models.local.GenreEntity

@Entity(tableName = "details_structure")
@TypeConverters(
    MovieCollectionConverters::class,
    GenreConverters::class,
    ProductionCompanyConverters::class,
    ISOCountryConverters::class,
    SpokenLanguagesConverters::class,
)
data class DetailsEntity(
    @PrimaryKey(autoGenerate = true) val detailsId: Int = 0,
    val adult: Boolean,
    @ColumnInfo(name = "backdrop_path")
    val backdropPath: String,
    @ColumnInfo(name = "belongs_to_collection")
    val belongsToCollection: MovieCollection,
    val budget: Int,
    val genres: List<GenreEntity>,
    val homepage: String,
    val id: Int,
    @ColumnInfo(name = "imdb_id")
    val imdbId: String,
    @ColumnInfo(name = "origin_country")
    val originCountry: String,
    @ColumnInfo(name = "original_language")
    val originalLanguage: String,
    @ColumnInfo(name = "original_title")
    val originalTitle: String,
    val overview: String,
    val popularity: Double,
    @ColumnInfo(name = "poster_path")
    val posterPath: String,
    @ColumnInfo(name = "production_companies")
    val productionCompanies: List<ProductionCompany>,
    @ColumnInfo(name = "production_countries")
    val productionCountries: List<ISOCountry>,
    @ColumnInfo(name = "release_date")
    val releaseDate: String,
    val revenue: Int,
    val runtime: Int,
    @ColumnInfo(name = "spoken_languages")
    val spokenLanguages: List<SpokenLanguages>,
    val status: String,
    val tagline: String,
    val title: String,
    val video: Boolean,
    @ColumnInfo(name = "vote_average")
    val voteAverage: Double,
    @ColumnInfo(name = "vote_count")
    val voteCount: Int,
)
