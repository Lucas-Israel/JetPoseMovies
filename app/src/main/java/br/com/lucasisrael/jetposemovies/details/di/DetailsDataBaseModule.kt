package br.com.lucasisrael.jetposemovies.details.di

import android.content.Context
import androidx.room.Room
import androidx.room.withTransaction
import br.com.lucasisrael.jetposemovies.details.data.datasource.database.DetailsDao
import br.com.lucasisrael.jetposemovies.details.data.datasource.database.DetailsDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DetailsDataBaseModule {

    @Provides
    @Singleton
    fun provideDetailsDataBase(@ApplicationContext appContext: Context): DetailsDataBase {
        return Room.databaseBuilder(
            appContext,
            DetailsDataBase::class.java,
            "details_database"
        ).build()
    }

    @Provides
    @Singleton
    suspend fun provideDetailsDao(dataBase: DetailsDataBase): DetailsDao {
        return dataBase.withTransaction {
            dataBase.detailsDao()
        }
    }
}
