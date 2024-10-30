package br.com.lucasisrael.jetposemovies.moviesList.di

import br.com.lucasisrael.jetposemovies.moviesList.data.repository.MoviesListRepository
import br.com.lucasisrael.jetposemovies.moviesList.domain.usecase.MoviesListUseCase
import br.com.lucasisrael.jetposemovies.moviesList.domain.usecase.MoviesListUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MoviesListUseCaseModule {

    @Provides
    @Singleton
    fun provideMoviesFromGenreUseCase(repository: MoviesListRepository): MoviesListUseCase {
        return MoviesListUseCaseImpl(repository)
    }
}
