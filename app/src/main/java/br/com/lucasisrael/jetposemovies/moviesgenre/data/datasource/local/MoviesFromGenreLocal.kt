package br.com.lucasisrael.jetposemovies.moviesgenre.data.datasource.local

import br.com.lucasisrael.jetposemovies.moviesgenre.data.models.local.MoviesFromGenreEntity
import br.com.lucasisrael.jetposemovies.moviesgenre.data.models.remote.MoviesFromGenreDto

interface MoviesFromGenreLocal {
    suspend fun saveMoviesFromGenreToDataBase(movies: MoviesFromGenreDto)
    suspend fun getMoviesFromGenreFromDataBase(): MoviesFromGenreEntity
}
