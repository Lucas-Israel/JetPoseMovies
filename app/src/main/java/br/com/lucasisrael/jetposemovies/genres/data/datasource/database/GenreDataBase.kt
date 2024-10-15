package br.com.lucasisrael.jetposemovies.genres.data.datasource.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import br.com.lucasisrael.jetposemovies.genres.data.datasource.converters.GenreTypeConverters
import br.com.lucasisrael.jetposemovies.genres.data.models.local.GenreEntity

@Database(
    entities = [GenreEntity::class],
    version = 1
)
@TypeConverters(GenreTypeConverters::class)
abstract class GenreDataBase: RoomDatabase() {

    abstract fun genreDao(): GenreDao

    companion object {
        @Volatile
        private var INSTANCE: GenreDataBase? = null

        fun getDataBase(context: Context): GenreDataBase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    GenreDataBase::class.java,
                    "genre_database",
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
