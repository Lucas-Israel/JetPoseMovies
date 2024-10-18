package br.com.lucasisrael.jetposemovies.moviesgenre.data.datasource.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import br.com.lucasisrael.jetposemovies.common.converters.ListConverters
import br.com.lucasisrael.jetposemovies.common.converters.MovieConverters
import br.com.lucasisrael.jetposemovies.moviesgenre.data.models.local.MoviesFromGenreEntity

@Database(
    entities = [MoviesFromGenreEntity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(
    MovieConverters::class,
    ListConverters::class
)
abstract class MoviesFromGenreDataBase : RoomDatabase() {

    abstract fun movieDao(): MoviesFromGenreDao

    companion object {
        @Volatile
        private var INSTANCE: MoviesFromGenreDataBase? = null

        fun getDataBase(context: Context): MoviesFromGenreDataBase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MoviesFromGenreDataBase::class.java,
                    "movies_database",
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
