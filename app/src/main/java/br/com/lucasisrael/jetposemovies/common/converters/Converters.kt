package br.com.lucasisrael.jetposemovies.common.converters

import androidx.room.TypeConverter
import br.com.lucasisrael.jetposemovies.genres.models.remote.GenreDto
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converters {

    @TypeConverter
    fun fromGenres(value: String): List<GenreDto> {
        val listType = object : TypeToken<List<GenreDto>>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromList(list: List<GenreDto>): String {
        return Gson().toJson(list)
    }

}
