package br.com.lucasisrael.jetposemovies.moviesList.data.repository

import br.com.lucasisrael.jetposemovies.common.models.Resource
import br.com.lucasisrael.jetposemovies.moviesList.data.models.local.MoviesListEntity
import br.com.lucasisrael.jetposemovies.moviesList.data.models.remote.MoviesListDto

interface MoviesListRepository {
    suspend fun getMoviesFromGenreFromApi(genreId: String, page: Int): Resource<MoviesListDto?>
    suspend fun saveMoviesFromGenreToDataBase(moviesListDto: MoviesListDto)
    suspend fun loadMoviesFromGenreFromDataBase(): MoviesListEntity
}
