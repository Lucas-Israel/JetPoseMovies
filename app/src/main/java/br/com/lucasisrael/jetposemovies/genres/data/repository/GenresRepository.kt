package br.com.lucasisrael.jetposemovies.genres.data.repository

import br.com.lucasisrael.jetposemovies.common.models.Resource
import br.com.lucasisrael.jetposemovies.genres.data.response.GenresResponse

interface GenresRepository {

    suspend fun getGenres(): Resource<GenresResponse?>
}
