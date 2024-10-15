package br.com.lucasisrael.jetposemovies.common.converters

import androidx.room.TypeConverter
import br.com.lucasisrael.jetposemovies.common.models.Movie
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MovieConverters {

    private val gson = Gson()

    @TypeConverter
    fun fromMovies(movies: List<Movie>?): String {
        return gson.toJson(movies)
    }

    @TypeConverter
    fun toMovies(json: String): List<Movie> {
        val type = object : TypeToken<List<Movie>>() {}.type
        return gson.fromJson(json, type)
    }
}
