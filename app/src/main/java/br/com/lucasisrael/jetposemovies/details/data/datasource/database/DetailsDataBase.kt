package br.com.lucasisrael.jetposemovies.details.data.datasource.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.lucasisrael.jetposemovies.details.data.models.local.DetailsEntity

@Database(
    entities = [DetailsEntity::class],
    version = 1
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
                    "details_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
