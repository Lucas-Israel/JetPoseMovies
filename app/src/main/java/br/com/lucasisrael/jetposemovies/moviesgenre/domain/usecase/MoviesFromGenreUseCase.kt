package br.com.lucasisrael.jetposemovies.moviesgenre.domain.usecase

import br.com.lucasisrael.jetposemovies.moviesgenre.data.models.local.MoviesFromGenreEntity
import br.com.lucasisrael.jetposemovies.moviesgenre.data.models.remote.MoviesFromGenreDto
import br.com.lucasisrael.jetposemovies.moviesgenre.domain.models.MoviesFromGenre

interface MoviesFromGenreUseCase {
    suspend fun getMoviesFromGenreRemote(genreId: String, page: Int): MoviesFromGenreDto
    suspend fun saveMoviesFromGenreToDataBase(movies: MoviesFromGenreDto)
    suspend fun loadMoviesFromGenreFromDataBase(genreId: String, page: Int): MoviesFromGenreEntity
    suspend fun getMoviesFromGenre(genreId: String, page: Int): MoviesFromGenre
}
