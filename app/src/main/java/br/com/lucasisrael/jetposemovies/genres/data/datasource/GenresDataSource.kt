package br.com.lucasisrael.jetposemovies.genres.data.datasource

import br.com.lucasisrael.jetposemovies.genres.data.models.remote.GenreDto

interface GenresDataSource {
    suspend fun getGenres(): List<GenreDto>
}
