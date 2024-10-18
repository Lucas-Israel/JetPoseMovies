package br.com.lucasisrael.jetposemovies.details.data.datasource.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import br.com.lucasisrael.jetposemovies.common.converters.DetailConverters
import br.com.lucasisrael.jetposemovies.common.converters.GenreConverters
import br.com.lucasisrael.jetposemovies.common.converters.ISOCountryConverters
import br.com.lucasisrael.jetposemovies.common.converters.ListConverters
import br.com.lucasisrael.jetposemovies.common.converters.MovieCollectionConverters
import br.com.lucasisrael.jetposemovies.common.converters.ProductionCompanyConverters
import br.com.lucasisrael.jetposemovies.common.converters.SpokenLanguagesConverters
import br.com.lucasisrael.jetposemovies.details.data.models.local.DetailsEntity

@Database(
    entities = [DetailsEntity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(
    DetailConverters::class,
    MovieCollectionConverters::class,
    GenreConverters::class,
    ProductionCompanyConverters::class,
    ISOCountryConverters::class,
    SpokenLanguagesConverters::class,
    ListConverters::class
)
abstract class DetailsDataBase : RoomDatabase() {

    abstract fun detailsDao(): DetailsDao

    companion object {
        @Volatile
        private var INSTANCE: DetailsDataBase? = null

        fun getDataBase(context: Context): DetailsDataBase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    DetailsDataBase::class.java,
                    "details_structure"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
