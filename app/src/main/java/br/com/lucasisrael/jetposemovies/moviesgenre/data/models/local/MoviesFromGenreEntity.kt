package br.com.lucasisrael.jetposemovies.moviesgenre.data.models.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import br.com.lucasisrael.jetposemovies.common.converters.ListConverters
import br.com.lucasisrael.jetposemovies.common.converters.MovieConverters
import br.com.lucasisrael.jetposemovies.common.models.Movie

@Entity(tableName = "movies_from_genre")
@TypeConverters(
    MovieConverters::class,
    ListConverters::class
)
data class MoviesFromGenreEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "movies_from_genre_id")
    val moviesFromGenreId: Int= 0,
    val page: Int,
    val results: List<Movie>,
    @ColumnInfo(name = "total_pages")
    val totalPages: Int,
    @ColumnInfo(name = "total_results")
    val totalResults: Int
)
