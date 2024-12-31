package br.com.lucasisrael.jetposemovies.common.converters

import androidx.room.TypeConverter
import br.com.lucasisrael.jetposemovies.genres.models.local.GenreEntity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converters {

    @TypeConverter
    fun fromGenres(value: String): List<GenreEntity> {
        val listType = object : TypeToken<List<GenreEntity>>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromList(list: List<GenreEntity>): String {
        return Gson().toJson(list)
    }

}
