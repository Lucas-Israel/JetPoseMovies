package br.com.lucasisrael.jetposemovies.genres.data.repository

import br.com.lucasisrael.jetposemovies.common.models.Resource
import br.com.lucasisrael.jetposemovies.genres.data.models.local.GenreEntity
import br.com.lucasisrael.jetposemovies.genres.data.models.remote.GenreDto

interface GenresRepository {
    suspend fun getGenresFromApi(): Resource<List<GenreDto>?>
    suspend fun saveGenresToDb(genres: List<GenreDto>)
    suspend fun loadGenresFromDb(): List<GenreEntity>
}
