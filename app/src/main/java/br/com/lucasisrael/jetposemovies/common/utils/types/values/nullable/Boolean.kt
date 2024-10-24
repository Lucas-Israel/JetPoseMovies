package br.com.lucasisrael.jetposemovies.common.utils.types.values.nullable

fun Boolean?.replaceNullable(param: Boolean = false) = this ?: param
