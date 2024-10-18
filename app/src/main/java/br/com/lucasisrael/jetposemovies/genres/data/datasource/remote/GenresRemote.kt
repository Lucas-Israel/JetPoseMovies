package br.com.lucasisrael.jetposemovies.genres.data.datasource.remote

import br.com.lucasisrael.jetposemovies.genres.data.models.remote.GenreDto

interface GenresRemote {
    suspend fun getGenres(): List<GenreDto>
}
