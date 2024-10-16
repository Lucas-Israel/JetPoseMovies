package br.com.lucasisrael.jetposemovies.common.utils.types.values.dephault

fun String?.replaceNullable(param: String = "") = this ?: param
