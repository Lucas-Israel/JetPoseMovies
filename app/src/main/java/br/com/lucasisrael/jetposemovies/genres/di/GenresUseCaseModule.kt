package br.com.lucasisrael.jetposemovies.genres.di

import br.com.lucasisrael.jetposemovies.genres.data.datasource.remote.GenresRemoteMediator
import br.com.lucasisrael.jetposemovies.genres.data.repository.GenresRepository
import br.com.lucasisrael.jetposemovies.genres.domain.usecase.GenresUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object GenresUseCaseModule {

    @Provides
    @Singleton
    fun providesGenresUseCase(
        genresRepository: GenresRepository,
        remoteMediator: GenresRemoteMediator,
    ): GenresUseCase {
        return GenresUseCase(genresRepository, remoteMediator)
    }
}
