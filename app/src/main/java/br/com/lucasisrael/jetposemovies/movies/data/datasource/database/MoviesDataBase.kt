package br.com.lucasisrael.jetposemovies.movies.data.datasource.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import br.com.lucasisrael.jetposemovies.common.converters.ListConverters
import br.com.lucasisrael.jetposemovies.movies.data.models.local.MovieEntity

@Database(
    entities = [MovieEntity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(
    ListConverters::class
)
abstract class MoviesDataBase : RoomDatabase() {

    abstract fun movieDao(): MoviesDao

    companion object {
        @Volatile
        private var INSTANCE: MoviesDataBase? = null

        fun getDataBase(context: Context): MoviesDataBase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MoviesDataBase::class.java,
                    "movies_database",
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
