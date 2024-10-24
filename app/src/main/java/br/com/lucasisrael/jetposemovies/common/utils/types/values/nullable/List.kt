package br.com.lucasisrael.jetposemovies.common.utils.types.values.nullable

fun <T>List<T>?.replaceNullable(param: List<T> = listOf()) = this ?: param
