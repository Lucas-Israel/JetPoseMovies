package br.com.lucasisrael.jetposemovies.common.converters

import com.google.gson.Gson
import kotlin.reflect.KClass

class GenericTypeConverter {
    private val gson = Gson()

    fun <T : Any> fromObject(obj: T, clazz: KClass<T>): String {
        return gson.toJson(obj, clazz::class.java)
    }

    fun <T : Any> toObject(json: String, clazz: KClass<T>): T {
        return gson.fromJson(json, clazz.java)
    }
}
