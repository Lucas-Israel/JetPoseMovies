package br.com.lucasisrael.jetposemovies.genres.domain.usecase

import br.com.lucasisrael.jetposemovies.genres.data.models.local.GenreEntity
import br.com.lucasisrael.jetposemovies.genres.data.models.remote.GenreDto
import br.com.lucasisrael.jetposemovies.genres.domain.models.GenreWithImgUrl

interface LoadGenresUseCase {
    suspend fun getImageForGenre(genreId: Int): String?
    suspend fun saveGenresToDb(genres: List<GenreDto>)
    suspend fun loadGenresFromDb(): List<GenreEntity>
    suspend fun createGenreWithImage(genre: GenreEntity): GenreWithImgUrl
    suspend fun getGenres(): List<GenreWithImgUrl>
}
