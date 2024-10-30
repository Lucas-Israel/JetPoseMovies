package br.com.lucasisrael.jetposemovies.genres.domain.usecase

import br.com.lucasisrael.jetposemovies.genres.data.models.local.GenreEntity
import br.com.lucasisrael.jetposemovies.genres.data.models.remote.GenreDto
import br.com.lucasisrael.jetposemovies.genres.domain.models.Genre

interface LoadGenresUseCase {
    suspend fun saveGenresToDb(genres: List<GenreDto>)
    suspend fun loadGenresFromDb(): List<GenreEntity>
    suspend fun getGenres(): List<Genre>
}
