package br.com.lucasisrael.jetposemovies.common.converters

import androidx.room.TypeConverter
import br.com.lucasisrael.jetposemovies.common.models.SpokenLanguages
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class SpokenLanguagesConverters {

    private val gson = Gson()

    @TypeConverter
    fun fromSpokenLanguages(spokenLanguages: List<SpokenLanguages>?): String {
        return gson.toJson(spokenLanguages)
    }

    @TypeConverter
    fun toSpokenLanguages(json: String): List<SpokenLanguages> {
        val type = object : TypeToken<List<SpokenLanguages>>() {}.type
        return gson.fromJson(json, type)
    }
}
