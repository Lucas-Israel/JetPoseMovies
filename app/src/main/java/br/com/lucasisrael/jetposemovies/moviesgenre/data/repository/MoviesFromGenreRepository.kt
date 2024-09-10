package br.com.lucasisrael.jetposemovies.moviesgenre.data.repository

import br.com.lucasisrael.jetposemovies.common.models.Resource
import br.com.lucasisrael.jetposemovies.moviesgenre.data.respose.MoviesFromGenreResponse

interface MoviesFromGenreRepository {
    suspend fun getMoviesFromGenre(id: String): Resource<MoviesFromGenreResponse?>
}
