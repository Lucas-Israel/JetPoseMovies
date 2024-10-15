package br.com.lucasisrael.jetposemovies.genres.data.datasource.converters

import androidx.room.TypeConverter
import br.com.lucasisrael.jetposemovies.common.converters.GenericTypeConverter
import br.com.lucasisrael.jetposemovies.genres.data.models.domain.Genre

class GenreTypeConverters {

    @TypeConverter
    fun fromGenre(genre: Genre): String {
        return GenericTypeConverter().fromObject(genre, Genre::class)
    }

    @TypeConverter
    fun toGenre(json: String): Genre {
        return GenericTypeConverter().toObject(json, Genre::class)
    }
}
