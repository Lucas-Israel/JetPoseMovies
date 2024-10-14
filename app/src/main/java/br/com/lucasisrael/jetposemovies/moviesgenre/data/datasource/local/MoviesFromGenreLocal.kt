package br.com.lucasisrael.jetposemovies.moviesgenre.data.datasource.local

import br.com.lucasisrael.jetposemovies.moviesgenre.data.models.local.MovieFromGenreEntity
import br.com.lucasisrael.jetposemovies.moviesgenre.data.models.remote.MovieFromGenreDto

interface MoviesFromGenreLocal {
    suspend fun saveMoviesFromGenreToDataBase(movies: List<MovieFromGenreDto>)
    suspend fun getMoviesFromGenreFromDataBase(): List<MovieFromGenreEntity>
}
