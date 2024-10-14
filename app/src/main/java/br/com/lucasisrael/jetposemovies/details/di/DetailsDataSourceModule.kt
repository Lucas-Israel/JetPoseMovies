package br.com.lucasisrael.jetposemovies.details.di

import br.com.lucasisrael.jetposemovies.details.data.api.DetailsApi
import br.com.lucasisrael.jetposemovies.details.data.datasource.database.DetailsDao
import br.com.lucasisrael.jetposemovies.details.data.datasource.local.DetailsLocal
import br.com.lucasisrael.jetposemovies.details.data.datasource.local.DetailsLocalImpl
import br.com.lucasisrael.jetposemovies.details.data.datasource.remote.DetailsRemote
import br.com.lucasisrael.jetposemovies.details.data.datasource.remote.DetailsRemoteImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DetailsDataSourceModule {

    @Provides
    @Singleton
    fun provideDetailsRemoteDataSource(api: DetailsApi): DetailsRemote {
        return DetailsRemoteImpl(api)
    }

    @Provides
    @Singleton
    fun provideDetailsLocalDataSource(details: DetailsDao): DetailsLocal {
        return DetailsLocalImpl(details)
    }
}
