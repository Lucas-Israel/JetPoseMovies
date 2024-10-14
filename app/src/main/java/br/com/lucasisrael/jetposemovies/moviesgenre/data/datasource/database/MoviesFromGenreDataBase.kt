package br.com.lucasisrael.jetposemovies.moviesgenre.data.datasource.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.lucasisrael.jetposemovies.moviesgenre.data.models.local.MovieFromGenreEntity

@Database(
    entities = [MovieFromGenreEntity::class],
    version = 1
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
