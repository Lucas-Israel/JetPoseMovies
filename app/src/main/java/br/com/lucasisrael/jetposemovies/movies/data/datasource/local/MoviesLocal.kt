package br.com.lucasisrael.jetposemovies.movies.data.datasource.local

import br.com.lucasisrael.jetposemovies.movies.data.models.local.MovieEntity
import br.com.lucasisrael.jetposemovies.movies.data.models.remote.MovieDto

interface MoviesLocal {
    suspend fun clearAll()
    suspend fun saveMoviesToDataBase(movies: MovieDto)
    suspend fun getMoviesFromDatabase(searchType: SearchType): List<MovieEntity>
}
