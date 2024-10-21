package br.com.lucasisrael.jetposemovies.moviesgenre.data.repository

import br.com.lucasisrael.jetposemovies.common.models.Resource
import br.com.lucasisrael.jetposemovies.moviesgenre.data.models.local.MoviesFromGenreEntity
import br.com.lucasisrael.jetposemovies.moviesgenre.data.models.remote.MoviesFromGenreDto

interface MoviesFromGenreRepository {
    suspend fun getMoviesFromGenreFromApi(genreId: String, page: Int): Resource<MoviesFromGenreDto?>
    suspend fun saveMoviesFromGenreToDataBase(moviesFromGenreDto: MoviesFromGenreDto)
    suspend fun loadMoviesFromGenreFromDataBase(): MoviesFromGenreEntity
}
