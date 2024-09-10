package br.com.lucasisrael.jetposemovies.genres.data.repository

import br.com.lucasisrael.jetposemovies.common.models.GenresWithImgUrl
import br.com.lucasisrael.jetposemovies.common.models.Resource

interface GenresRepository {

    suspend fun getGenres(): Resource<MutableList<GenresWithImgUrl>?>
}
