package br.com.lucasisrael.jetposemovies.genres.data.models.response

import br.com.lucasisrael.jetposemovies.genres.data.models.remote.GenreDto

data class GenreResponse(
    val genres: List<GenreDto>
)
