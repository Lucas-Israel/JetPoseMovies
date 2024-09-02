package br.com.lucasisrael.jetposemovies.genres.di

import br.com.lucasisrael.jetposemovies.genres.data.datasource.GenresDataSource
import br.com.lucasisrael.jetposemovies.genres.data.repository.GenresRepository
import br.com.lucasisrael.jetposemovies.genres.data.repository.GenresRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object GenresRepositoryModule {

    @Provides
    @Singleton
    fun provideGenresRepository(dataSource: GenresDataSource): GenresRepository {
        return GenresRepositoryImpl(dataSource)
    }
}
