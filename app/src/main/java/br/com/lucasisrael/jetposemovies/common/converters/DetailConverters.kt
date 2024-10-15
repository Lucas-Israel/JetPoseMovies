package br.com.lucasisrael.jetposemovies.common.converters

import androidx.room.TypeConverter
import br.com.lucasisrael.jetposemovies.details.data.models.local.DetailsEntity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class DetailConverters {

    private val gson = Gson()

    @TypeConverter
    fun fromDetail(detail: DetailsEntity): String {
        return gson.toJson(detail)
    }

    @TypeConverter
    fun toDetail(json: String): DetailsEntity {
        val type = object : TypeToken<DetailsEntity>() {}.type
        return gson.fromJson(json, type)
    }
}
