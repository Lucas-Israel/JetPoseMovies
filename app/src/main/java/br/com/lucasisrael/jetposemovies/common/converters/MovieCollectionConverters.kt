package br.com.lucasisrael.jetposemovies.common.converters

import androidx.room.TypeConverter
import br.com.lucasisrael.jetposemovies.details.models.local.MovieCollectionEntity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MovieCollectionConverters {

    private val gson = Gson()

    @TypeConverter
    fun fromMovieCollection(movieCollectionEntity: MovieCollectionEntity?): String {
        return gson.toJson(movieCollectionEntity)
    }

    @TypeConverter
    fun toMovieCollection(json: String): MovieCollectionEntity {
        val type = object : TypeToken<MovieCollectionEntity>() {}.type
        return gson.fromJson(json, type)
    }
}
