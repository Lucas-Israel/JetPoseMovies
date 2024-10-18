package br.com.lucasisrael.jetposemovies.common.converters

import androidx.room.TypeConverter
import br.com.lucasisrael.jetposemovies.common.models.MovieCollection
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MovieCollectionConverters {

    private val gson = Gson()

    @TypeConverter
    fun fromMovieCollection(movieCollection: MovieCollection): String {
        return gson.toJson(movieCollection)
    }

    @TypeConverter
    fun toMovieCollection(json: String): MovieCollection {
        val type = object : TypeToken<MovieCollection>() {}.type
        return gson.fromJson(json, type)
    }
}
