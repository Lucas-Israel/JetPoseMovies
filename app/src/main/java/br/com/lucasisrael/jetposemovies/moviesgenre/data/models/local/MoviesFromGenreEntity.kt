package br.com.lucasisrael.jetposemovies.moviesgenre.data.models.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import br.com.lucasisrael.jetposemovies.common.models.Movie

@Entity
data class MoviesFromGenreEntity(
    @PrimaryKey
    val page: Int,
    val results: List<Movie>,
    val total_pages: Int,
    val total_results: Int
)
