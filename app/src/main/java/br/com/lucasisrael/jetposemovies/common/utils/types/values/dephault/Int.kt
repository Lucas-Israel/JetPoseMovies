package br.com.lucasisrael.jetposemovies.common.utils.types.values.dephault

fun Int?.replaceNullable(param: Int = 0) = this ?: param
