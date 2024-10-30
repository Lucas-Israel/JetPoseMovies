package br.com.lucasisrael.jetposemovies.moviesList.data.datasource.remote

import br.com.lucasisrael.jetposemovies.moviesList.data.api.MoviesListApi
import br.com.lucasisrael.jetposemovies.moviesList.data.mappers.toMoviesFromGenreDto
import br.com.lucasisrael.jetposemovies.moviesList.data.models.remote.MoviesListDto
import javax.inject.Inject

class MoviesListRemoteImpl @Inject constructor(private val api: MoviesListApi) :
    MoviesListRemote {
    override suspend fun getMoviesFromGenre(genreId: String, page: Int): MoviesListDto {
        return api.getMoviesFromGenre(genreId = genreId, page = page).toMoviesFromGenreDto()
    }
}
