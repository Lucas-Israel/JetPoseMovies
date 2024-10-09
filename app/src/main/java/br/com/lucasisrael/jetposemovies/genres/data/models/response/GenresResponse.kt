package br.com.lucasisrael.jetposemovies.genres.data.models.response

import br.com.lucasisrael.jetposemovies.genres.data.models.remote.GenresDto

data class GenresResponse(
    val genres: List<GenresDto>
)
