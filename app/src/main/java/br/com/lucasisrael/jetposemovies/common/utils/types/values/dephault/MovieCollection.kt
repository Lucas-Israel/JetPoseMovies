package br.com.lucasisrael.jetposemovies.common.utils.types.values.dephault

import br.com.lucasisrael.jetposemovies.common.models.MovieCollection

fun MovieCollection?.replaceNullable(param: MovieCollection = MovieCollection()) = this ?: param
