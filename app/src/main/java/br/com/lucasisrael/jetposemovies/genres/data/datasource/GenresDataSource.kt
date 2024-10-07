package br.com.lucasisrael.jetposemovies.genres.data.datasource

import br.com.lucasisrael.jetposemovies.genres.data.response.GenresResponse

interface GenresDataSource {
    suspend fun getGenres(): GenresResponse
}
