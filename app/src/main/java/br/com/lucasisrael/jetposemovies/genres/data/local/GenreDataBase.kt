package br.com.lucasisrael.jetposemovies.genres.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import br.com.lucasisrael.jetposemovies.genres.data.models.local.GenreEntity

@Database(
    entities = [GenreEntity::class],
    version = 1
)
abstract class GenreDataBase: RoomDatabase() {
    abstract val dao: GenreDao
}
