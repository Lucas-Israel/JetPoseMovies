package br.com.lucasisrael.jetposemovies.common.di

import android.content.Context
import androidx.room.Room
import br.com.lucasisrael.jetposemovies.common.database.JetPoseDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppDataBaseModule {

    @Provides
    @Singleton
    fun provideMoviesDataBaseModule(@ApplicationContext appContext: Context): JetPoseDataBase {
        return Room.databaseBuilder(
            appContext,
            JetPoseDataBase::class.java,
            "jetpose_database"
        ).build()
    }

}