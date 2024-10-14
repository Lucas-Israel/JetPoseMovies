package br.com.lucasisrael.jetposemovies.moviesgenre.data.repository

import br.com.lucasisrael.jetposemovies.common.models.Resource
import br.com.lucasisrael.jetposemovies.moviesgenre.data.models.local.MovieFromGenreEntity
import br.com.lucasisrael.jetposemovies.moviesgenre.data.models.response.MoviesFromGenreResponse

interface MoviesFromGenreRepository {
    suspend fun getMoviesFromGenre(): Resource<MoviesFromGenreResponse?>
    suspend fun refreshMoviesFromGenre()
}
