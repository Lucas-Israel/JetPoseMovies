package br.com.lucasisrael.jetposemovies.genres.data.repository

import br.com.lucasisrael.jetposemovies.common.models.GenresWithImgUrl
import br.com.lucasisrael.jetposemovies.common.models.Resource
import br.com.lucasisrael.jetposemovies.genres.data.models.local.GenreEntity

interface GenresRepository {
    suspend fun getGenresWithImage(): Resource<List<GenresWithImgUrl>?>
    suspend fun refreshGenres()
}
