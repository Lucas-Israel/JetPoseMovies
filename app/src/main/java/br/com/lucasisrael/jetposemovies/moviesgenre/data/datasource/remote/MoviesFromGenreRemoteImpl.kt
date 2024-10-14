package br.com.lucasisrael.jetposemovies.moviesgenre.data.datasource.remote

import br.com.lucasisrael.jetposemovies.moviesgenre.data.api.MoviesGenreApi
import br.com.lucasisrael.jetposemovies.moviesgenre.data.models.remote.MoviesFromGenreDto
import javax.inject.Inject

class MoviesFromGenreRemoteImpl @Inject constructor(private val api: MoviesGenreApi) :
    MoviesFromGenreRemote {
    override suspend fun getMoviesFromGenre(genreId: String, page: Int): MoviesFromGenreDto {
        return api.getMoviesFromGenre(genreId = genreId, page = page)
    }
}
