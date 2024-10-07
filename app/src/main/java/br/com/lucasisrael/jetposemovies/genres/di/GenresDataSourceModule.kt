package br.com.lucasisrael.jetposemovies.genres.di

import br.com.lucasisrael.jetposemovies.genres.data.api.GenresApi
import br.com.lucasisrael.jetposemovies.genres.data.datasource.GenresDataSource
import br.com.lucasisrael.jetposemovies.genres.data.datasource.GenresDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object GenresDataSourceModule {

    @Provides
    @Singleton
    fun provideGenresDataSource(api: GenresApi): GenresDataSource {
        return GenresDataSourceImpl(api)
    }
 }
