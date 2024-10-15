package br.com.lucasisrael.jetposemovies.common.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlin.reflect.KClass

class GenericListConverter {

    private val gson = Gson()

    @TypeConverter
    fun <T : Any>fromList(list: List<T>, clazz: KClass<T>): String {
        val type = TypeToken.getParameterized(List::class.java, clazz.java).type
        return gson.toJson(list, type)
    }

    @TypeConverter
    fun <T : Any> toList(json: String, clazz: KClass<T>): List<T> {
        val type = TypeToken.getParameterized(List::class.java, clazz.java).type
        return gson.fromJson(json, type)
    }
}
