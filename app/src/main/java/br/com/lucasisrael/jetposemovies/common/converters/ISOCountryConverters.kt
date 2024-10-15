package br.com.lucasisrael.jetposemovies.common.converters

import androidx.room.TypeConverter
import br.com.lucasisrael.jetposemovies.common.models.ISOCountry
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ISOCountryConverters {

    private val gson = Gson()

    @TypeConverter
    fun fromISOCountries(isoCountries: List<ISOCountry>?): String {
        return gson.toJson(isoCountries)
    }

    @TypeConverter
    fun toISOCountries(json: String): List<ISOCountry> {
        val type = object : TypeToken<List<ISOCountry>>() {}.type
        return gson.fromJson(json, type)
    }
}
