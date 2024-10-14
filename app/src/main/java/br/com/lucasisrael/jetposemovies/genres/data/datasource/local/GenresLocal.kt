package br.com.lucasisrael.jetposemovies.genres.data.datasource.local

import br.com.lucasisrael.jetposemovies.genres.data.models.local.GenreEntity

interface GenresLocal {
    suspend fun saveGenresToDataBase(genres: List<GenreEntity>)
    suspend fun getGenresFromDataBase(): List<GenreEntity>
}
