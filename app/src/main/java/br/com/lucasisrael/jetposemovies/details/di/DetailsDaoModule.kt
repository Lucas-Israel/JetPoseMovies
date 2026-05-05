package br.com.lucasisrael.jetposemovies.details.di

import br.com.lucasisrael.jetposemovies.common.database.JetPoseDataBase
import br.com.lucasisrael.jetposemovies.details.data.datasource.local.DetailsDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DetailsDaoModule {

    @Provides
    @Singleton
    fun provideDetailsDao(database: JetPoseDataBase): DetailsDao {
        return database.detailsDao
    }
}
