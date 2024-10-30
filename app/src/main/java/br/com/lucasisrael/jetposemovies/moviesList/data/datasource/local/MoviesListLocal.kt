package br.com.lucasisrael.jetposemovies.moviesList.data.datasource.local

import br.com.lucasisrael.jetposemovies.moviesList.data.models.local.MoviesListEntity
import br.com.lucasisrael.jetposemovies.moviesList.data.models.remote.MoviesListDto

interface MoviesListLocal {
    suspend fun saveMoviesFromGenreToDataBase(movies: MoviesListDto)
    suspend fun getMoviesFromGenreFromDataBase(): MoviesListEntity
}
