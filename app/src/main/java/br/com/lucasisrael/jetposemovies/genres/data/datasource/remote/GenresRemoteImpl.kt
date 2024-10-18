package br.com.lucasisrael.jetposemovies.genres.data.datasource.remote

import br.com.lucasisrael.jetposemovies.genres.data.api.GenresApi
import br.com.lucasisrael.jetposemovies.genres.data.models.remote.GenreDto
import javax.inject.Inject

class GenresRemoteImpl @Inject constructor(private val api: GenresApi): GenresRemote {

    override suspend fun getGenres(): List<GenreDto> {
        return api.getGenres().genres
    }
}
