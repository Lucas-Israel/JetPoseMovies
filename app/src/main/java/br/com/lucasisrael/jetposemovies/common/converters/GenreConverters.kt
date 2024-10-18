package br.com.lucasisrael.jetposemovies.common.converters

import androidx.room.TypeConverter
import br.com.lucasisrael.jetposemovies.genres.data.models.local.GenreEntity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class GenreConverters {

    private val gson = Gson()

    @TypeConverter
    fun fromGenres(genres: List<GenreEntity>?): String {
        return gson.toJson(genres)
    }

    @TypeConverter
    fun toGenre(json: String): List<GenreEntity> {
        val type = object : TypeToken<List<GenreEntity>>() {}.type
        return gson.fromJson(json, type)
    }
}
