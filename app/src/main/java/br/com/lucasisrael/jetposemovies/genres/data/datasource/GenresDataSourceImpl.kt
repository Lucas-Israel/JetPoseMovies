package br.com.lucasisrael.jetposemovies.genres.data.datasource

import br.com.lucasisrael.jetposemovies.genres.data.api.GenresApi
import br.com.lucasisrael.jetposemovies.genres.data.models.remote.GenreDto
import javax.inject.Inject

class GenresDataSourceImpl @Inject constructor(private val api: GenresApi): GenresDataSource {

    override suspend fun getGenres(): List<GenreDto> {
        return api.getGenres().genres
    }
}
