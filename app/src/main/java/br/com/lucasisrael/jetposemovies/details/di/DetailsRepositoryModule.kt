package br.com.lucasisrael.jetposemovies.details.di

import br.com.lucasisrael.jetposemovies.details.data.datasource.local.DetailsLocal
import br.com.lucasisrael.jetposemovies.details.data.datasource.remote.DetailsRemote
import br.com.lucasisrael.jetposemovies.details.data.repository.DetailsRepository
import br.com.lucasisrael.jetposemovies.details.data.repository.DetailsRepositoryImpl
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
    fun provideDetailsRepository(
        detailsRemote: DetailsRemote,
        detailsLocal: DetailsLocal
    ): DetailsRepository {
        return DetailsRepositoryImpl(detailsRemote, detailsLocal)
    }
}
