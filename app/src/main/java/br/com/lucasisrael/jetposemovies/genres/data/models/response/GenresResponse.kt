package br.com.lucasisrael.jetposemovies.genres.data.models.response

import br.com.lucasisrael.jetposemovies.genres.data.models.remote.GenreDto

data class GenresResponse(
    val genres: List<GenreDto>
)
