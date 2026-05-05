package br.com.lucasisrael.jetposemovies.details.di

import br.com.lucasisrael.jetposemovies.details.data.api.DetailsApi
import br.com.lucasisrael.jetposemovies.details.data.datasource.local.DetailsDao
import br.com.lucasisrael.jetposemovies.details.data.repository.DetailsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DetailsRepositoryModule {

    @Provides
    @Singleton
    fun provideDetailsRepository(dao: DetailsDao, api: DetailsApi): DetailsRepository {
        return DetailsRepository(dao = dao, api = api)
    }
}
