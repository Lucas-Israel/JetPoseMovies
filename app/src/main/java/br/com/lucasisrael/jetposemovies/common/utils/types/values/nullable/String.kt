package br.com.lucasisrael.jetposemovies.common.utils.types.values.nullable

fun String?.replaceNullable(param: String = "") = this ?: param
