package br.com.lucasisrael.jetposemovies.details.data.datasource.converters

import androidx.room.TypeConverter
import br.com.lucasisrael.jetposemovies.common.converters.GenericTypeConverter
import br.com.lucasisrael.jetposemovies.common.models.MovieCollection

class DetailsTypeConverters {

    @TypeConverter
    fun fromMovieCollection(movieCollection: MovieCollection): String {
        return GenericTypeConverter().fromObject(movieCollection, MovieCollection::class)
    }

    @TypeConverter
    fun toMovieCollection(json: String): MovieCollection {
        return GenericTypeConverter().toObject(json, MovieCollection::class)
    }
}
