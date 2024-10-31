package br.com.lucasisrael.jetposemovies.movies.data.repository

import br.com.lucasisrael.jetposemovies.common.models.Resource
import br.com.lucasisrael.jetposemovies.movies.data.datasource.local.SearchType
import br.com.lucasisrael.jetposemovies.movies.data.models.local.MovieEntity
import br.com.lucasisrael.jetposemovies.movies.data.models.remote.MovieDto

interface MoviesListRepository {
    suspend fun fetchMovies(searchType: SearchType): Resource<List<MovieDto>?>
    suspend fun saveMoviesFromGenreToDataBase(movieDto: MovieDto)
    suspend fun loadMoviesFromDataBase(searchType: SearchType): List<MovieEntity>
}
