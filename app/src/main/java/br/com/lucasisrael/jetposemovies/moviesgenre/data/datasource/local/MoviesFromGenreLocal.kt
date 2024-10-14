package br.com.lucasisrael.jetposemovies.moviesgenre.data.datasource.local

import br.com.lucasisrael.jetposemovies.moviesgenre.data.models.local.MovieFromGenreEntity

interface MoviesFromGenreLocal {
    suspend fun saveMoviesFromGenreToDataBase(movies: List<MovieFromGenreEntity>)
    suspend fun getMoviesFromGenreFromDataBase(): List<MovieFromGenreEntity>
}
