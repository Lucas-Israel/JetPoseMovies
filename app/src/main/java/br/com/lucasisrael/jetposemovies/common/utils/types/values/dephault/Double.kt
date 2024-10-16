package br.com.lucasisrael.jetposemovies.common.utils.types.values.dephault

fun Double?.replaceNullable(param: Double = 0.00) = this ?: param
