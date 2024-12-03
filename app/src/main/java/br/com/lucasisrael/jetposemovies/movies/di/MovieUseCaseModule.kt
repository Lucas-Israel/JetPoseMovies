package br.com.lucasisrael.jetposemovies.movies.di

import br.com.lucasisrael.jetposemovies.movies.data.datasource.remote.MoviesRemoteMediator
import br.com.lucasisrael.jetposemovies.movies.data.repository.MoviesRepository
import br.com.lucasisrael.jetposemovies.movies.domain.usecase.MoviesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MovieUseCaseModule {

    @Provides
    @Singleton
    fun provideMovieUseCase(moviesRepository: MoviesRepository, remoteMediator: MoviesRemoteMediator): MoviesUseCase {
        return MoviesUseCase(moviesRepository = moviesRepository, remoteMediator = remoteMediator)
    }
}