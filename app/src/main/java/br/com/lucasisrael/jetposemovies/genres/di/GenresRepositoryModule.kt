package br.com.lucasisrael.jetposemovies.genres.di

import br.com.lucasisrael.jetposemovies.genres.data.api.GenresApi
import br.com.lucasisrael.jetposemovies.genres.data.datasource.local.GenresDao
import br.com.lucasisrael.jetposemovies.genres.data.repository.GenresRepository
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
    fun provideGenresRepository(
        dao: GenresDao,
        api: GenresApi,
    ): GenresRepository {
        return GenresRepository(dao, api)
    }
}
