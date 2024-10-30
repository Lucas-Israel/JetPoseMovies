package br.com.lucasisrael.jetposemovies.moviesList.domain.usecase

import br.com.lucasisrael.jetposemovies.moviesList.data.models.local.MoviesListEntity
import br.com.lucasisrael.jetposemovies.moviesList.data.models.remote.MoviesListDto
import br.com.lucasisrael.jetposemovies.moviesList.domain.models.MoviesList

interface MoviesListUseCase {
    suspend fun getMoviesFromGenreRemote(genreId: String, page: Int): MoviesListDto
    suspend fun saveMoviesFromGenreToDataBase(movies: MoviesListDto)
    suspend fun loadMoviesFromGenreFromDataBase(genreId: String, page: Int): MoviesListEntity
    suspend fun getMoviesFromGenre(genreId: String, page: Int): MoviesList
}
