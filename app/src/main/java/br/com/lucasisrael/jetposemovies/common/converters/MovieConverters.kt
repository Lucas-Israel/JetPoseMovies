package br.com.lucasisrael.jetposemovies.common.converters

import androidx.room.TypeConverter
import br.com.lucasisrael.jetposemovies.movies.data.models.remote.MovieDto
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MovieConverters {

    private val gson = Gson()

    @TypeConverter
    fun fromMovies(movies: List<MovieDto>?): String {
        return gson.toJson(movies)
    }

    @TypeConverter
    fun toMovies(json: String): List<MovieDto> {
        val type = object : TypeToken<List<MovieDto>>() {}.type
        return gson.fromJson(json, type)
    }
}
