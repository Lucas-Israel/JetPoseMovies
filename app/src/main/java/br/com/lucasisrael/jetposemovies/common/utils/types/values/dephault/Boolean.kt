package br.com.lucasisrael.jetposemovies.common.utils.types.values.dephault

fun Boolean?.replaceNullable(param: Boolean = false) = this ?: param
