package br.com.lucasisrael.jetposemovies.moviesgenre.data.datasource

import br.com.lucasisrael.jetposemovies.moviesgenre.data.api.MoviesGenreApi
import br.com.lucasisrael.jetposemovies.moviesgenre.data.respose.MoviesFromGenreResponse
import javax.inject.Inject

class MoviesFromGenreDataSourceImpl @Inject constructor(private val api: MoviesGenreApi) :
    MoviesFromGenreDataSource {
    override suspend fun getMoviesFromGenre(): MoviesFromGenreResponse {
        return api.getMoviesFromGenre()
    }
}
