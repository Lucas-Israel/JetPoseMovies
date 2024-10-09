package br.com.lucasisrael.jetposemovies.genres.data.datasource

import br.com.lucasisrael.jetposemovies.genres.data.models.remote.GenresDto

interface GenresDataSource {
    suspend fun getGenres(): List<GenresDto>
}
