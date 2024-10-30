package br.com.lucasisrael.jetposemovies.moviesList.data.datasource.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import br.com.lucasisrael.jetposemovies.common.converters.ListConverters
import br.com.lucasisrael.jetposemovies.common.converters.MovieConverters
import br.com.lucasisrael.jetposemovies.moviesList.data.models.local.MoviesListEntity

@Database(
    entities = [MoviesListEntity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(
    MovieConverters::class,
    ListConverters::class
)
abstract class MoviesListDataBase : RoomDatabase() {

    abstract fun movieDao(): MoviesListDao

    companion object {
        @Volatile
        private var INSTANCE: MoviesListDataBase? = null

        fun getDataBase(context: Context): MoviesListDataBase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MoviesListDataBase::class.java,
                    "movies_database",
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
