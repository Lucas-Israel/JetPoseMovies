package br.com.lucasisrael.jetposemovies.genres.models.response

import br.com.lucasisrael.jetposemovies.genres.models.remote.GenreDto

data class GenreResponse(
    val genres: List<GenreDto>
)
