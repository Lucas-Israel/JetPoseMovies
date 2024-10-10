package br.com.lucasisrael.jetposemovies.moviesgenre.data.datasource

import br.com.lucasisrael.jetposemovies.moviesgenre.data.api.MoviesGenreApi
import br.com.lucasisrael.jetposemovies.moviesgenre.data.models.response.MoviesFromGenreResponse
import javax.inject.Inject

class MoviesFromGenreDataSourceImpl @Inject constructor(private val api: MoviesGenreApi) :
    MoviesFromGenreDataSource {
    override suspend fun getMoviesFromGenre(id: String, page: Int): MoviesFromGenreResponse {
        return api.getMoviesFromGenre(id = id, page = page)
    }
}
