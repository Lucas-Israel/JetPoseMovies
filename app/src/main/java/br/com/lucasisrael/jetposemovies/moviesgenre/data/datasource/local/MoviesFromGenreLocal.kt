package br.com.lucasisrael.jetposemovies.moviesgenre.data.datasource.local

import br.com.lucasisrael.jetposemovies.moviesgenre.data.models.local.MoviesFromGenreEntity

interface MoviesFromGenreLocal {
    suspend fun saveMoviesFromGenreToDataBase(movies: MoviesFromGenreEntity)
    suspend fun getMoviesFromGenreFromDataBase(): MoviesFromGenreEntity
}
