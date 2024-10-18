package br.com.lucasisrael.jetposemovies.common.utils.types.values.dephault

fun Long?.replaceNullable(param: Long = 0L) = this ?: param
