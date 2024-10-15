package br.com.lucasisrael.jetposemovies.common.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ListConverters {

    private val gson = Gson()

    @TypeConverter
    fun fromIntList(value: List<Int>?): String {
        return gson.toJson(value)
    }

    @TypeConverter
    fun toIntList(json: String): List<Int> {
        val type = object : TypeToken<List<Int>>() {}.type
        return gson.fromJson(json, type)
    }
}