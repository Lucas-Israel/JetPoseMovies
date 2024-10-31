package br.com.lucasisrael.jetposemovies.movies.data.repository

import br.com.lucasisrael.jetposemovies.common.models.Resource
import br.com.lucasisrael.jetposemovies.movies.data.models.local.MovieEntity
import br.com.lucasisrael.jetposemovies.movies.data.models.remote.MovieDto

interface MoviesListRepository {
    suspend fun getMoviesFromGenreFromApi(genreId: String, page: Int): Resource<List<MovieDto?>?>
    suspend fun saveMoviesFromGenreToDataBase(movieDto: MovieDto)
    suspend fun loadMoviesFromGenreFromDataBase(genreId: String): List<MovieEntity>
}
