package br.com.lucasisrael.jetposemovies.movies.domain.usecase

import br.com.lucasisrael.jetposemovies.movies.data.models.local.MovieEntity
import br.com.lucasisrael.jetposemovies.movies.data.models.remote.MovieDto
import br.com.lucasisrael.jetposemovies.movies.domain.models.MovieDomain

interface MoviesUseCase {
    suspend fun getMoviesFromGenreRemote(genreId: String, page: Int): List<MovieDto?>?
    suspend fun saveMoviesFromGenreToDataBase(movies: MovieDto)
    suspend fun loadMoviesFromGenreFromDataBase(genreId: String, page: Int): List<MovieEntity>
    suspend fun getMoviesFromGenre(genreId: String, page: Int): List<MovieDomain>
}
