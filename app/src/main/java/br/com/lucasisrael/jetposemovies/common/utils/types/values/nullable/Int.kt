package br.com.lucasisrael.jetposemovies.common.utils.types.values.nullable

fun Int?.replaceNullable(param: Int = 0) = this ?: param
