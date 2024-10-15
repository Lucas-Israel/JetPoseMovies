package br.com.lucasisrael.jetposemovies.details.data.datasource.converters

import br.com.lucasisrael.jetposemovies.common.converters.GenericTypeConverter
import br.com.lucasisrael.jetposemovies.common.models.MovieCollection

fun movieCollectionToString(movieCollection: MovieCollection): String {
    return GenericTypeConverter().fromObject(movieCollection, MovieCollection::class)
}

fun stringToMovieCollection(json: String): MovieCollection {
    return GenericTypeConverter().toObject(json, MovieCollection::class)
}
