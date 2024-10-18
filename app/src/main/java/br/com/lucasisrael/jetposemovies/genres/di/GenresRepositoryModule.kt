package br.com.lucasisrael.jetposemovies.genres.di

import br.com.lucasisrael.jetposemovies.genres.data.datasource.local.GenresLocal
import br.com.lucasisrael.jetposemovies.genres.data.datasource.remote.GenresRemote
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
    fun provideGenresRepository(
        genresRemote: GenresRemote,
        genresLocal: GenresLocal
    ): GenresRepository {
        return GenresRepositoryImpl(genresRemote, genresLocal)
    }
}
