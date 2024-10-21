package br.com.lucasisrael.jetposemovies.moviesgenre.di

import br.com.lucasisrael.jetposemovies.moviesgenre.data.repository.MoviesFromGenreRepository
import br.com.lucasisrael.jetposemovies.moviesgenre.domain.usecase.MoviesFromGenreUseCase
import br.com.lucasisrael.jetposemovies.moviesgenre.domain.usecase.MoviesFromGenreUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MoviesFromGenreUseCaseModule {

    @Provides
    @Singleton
    fun provideMoviesFromGenreUseCase(repository: MoviesFromGenreRepository): MoviesFromGenreUseCase {
        return MoviesFromGenreUseCaseImpl(repository)
    }
}
