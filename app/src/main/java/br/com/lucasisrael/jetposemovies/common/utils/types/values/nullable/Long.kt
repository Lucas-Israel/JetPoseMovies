package br.com.lucasisrael.jetposemovies.common.utils.types.values.nullable

fun Long?.replaceNullable(param: Long = 0L) = this ?: param
