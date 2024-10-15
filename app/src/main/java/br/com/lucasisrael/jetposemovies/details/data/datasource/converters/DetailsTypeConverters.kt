package br.com.lucasisrael.jetposemovies.details.data.datasource.converters

import androidx.room.TypeConverter
import br.com.lucasisrael.jetposemovies.common.models.MovieCollection

class DetailsTypeConverters {

    @TypeConverter
    fun fromMovieCollection(movieCollection: MovieCollection): String {
        return movieCollectionToString(movieCollection)
    }

    @TypeConverter
    fun toMovieCollection(json: String): MovieCollection {
        return stringToMovieCollection(json)
    }
}
