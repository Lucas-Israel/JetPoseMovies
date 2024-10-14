package br.com.lucasisrael.jetposemovies.moviesgenre.data.repository

import br.com.lucasisrael.jetposemovies.common.models.Resource
import br.com.lucasisrael.jetposemovies.moviesgenre.data.models.local.MoviesFromGenreEntity

interface MoviesFromGenreRepository {
    suspend fun getMoviesFromGenre(genreId: String, page: Int): Resource<MoviesFromGenreEntity?>
    suspend fun refreshMoviesFromGenre(genreId: String, page: Int)
}
