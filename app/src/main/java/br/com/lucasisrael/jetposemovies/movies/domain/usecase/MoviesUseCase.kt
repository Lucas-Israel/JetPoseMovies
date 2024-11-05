package br.com.lucasisrael.jetposemovies.movies.domain.usecase

import br.com.lucasisrael.jetposemovies.movies.data.datasource.local.SearchType
import br.com.lucasisrael.jetposemovies.movies.data.models.local.MovieEntity
import br.com.lucasisrael.jetposemovies.movies.data.models.query.MovieApiQuery
import br.com.lucasisrael.jetposemovies.movies.data.models.remote.MovieDto
import br.com.lucasisrael.jetposemovies.movies.domain.models.MovieDomain

interface MoviesUseCase {
    suspend fun fetchMovies(movieApiQuery: MovieApiQuery): List<MovieDto>
    suspend fun saveMovies(movies: List<MovieDto>)
    suspend fun loadMovies(searchType: SearchType): List<MovieEntity>
    suspend fun synchronizeMovies(searchType: SearchType): List<MovieDomain>
}
