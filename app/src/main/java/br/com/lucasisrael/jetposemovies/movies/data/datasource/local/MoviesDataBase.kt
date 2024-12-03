package br.com.lucasisrael.jetposemovies.movies.data.datasource.local

import androidx.room.Database
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

}
