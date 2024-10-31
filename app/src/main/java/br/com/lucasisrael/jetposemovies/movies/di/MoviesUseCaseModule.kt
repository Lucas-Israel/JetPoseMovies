package br.com.lucasisrael.jetposemovies.movies.di

import br.com.lucasisrael.jetposemovies.movies.data.repository.MoviesListRepository
import br.com.lucasisrael.jetposemovies.movies.domain.usecase.MoviesUseCase
import br.com.lucasisrael.jetposemovies.movies.domain.usecase.MoviesUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MoviesUseCaseModule {

    @Provides
    @Singleton
    fun provideMoviesFromGenreUseCase(repository: MoviesListRepository): MoviesUseCase {
        return MoviesUseCaseImpl(repository)
    }
}
