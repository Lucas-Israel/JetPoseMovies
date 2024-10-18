package br.com.lucasisrael.jetposemovies.common.converters

import androidx.room.TypeConverter
import br.com.lucasisrael.jetposemovies.common.models.ProductionCompany
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ProductionCompanyConverters {

    private val gson = Gson()

    @TypeConverter
    fun fromProductionCompanies(productionCompanies: List<ProductionCompany>?): String {
        return gson.toJson(productionCompanies)
    }

    @TypeConverter
    fun toProductionCompanies(json: String): List<ProductionCompany> {
        val type = object : TypeToken<List<ProductionCompany>>() {}.type
        return gson.fromJson(json, type)
    }
}
