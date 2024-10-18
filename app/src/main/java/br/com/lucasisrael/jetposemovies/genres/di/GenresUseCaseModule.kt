package br.com.lucasisrael.jetposemovies.genres.di

import br.com.lucasisrael.jetposemovies.genres.data.repository.GenresRepository
import br.com.lucasisrael.jetposemovies.genres.domain.usecase.LoadGenresUseCase
import br.com.lucasisrael.jetposemovies.genres.domain.usecase.LoadGenresUseCaseImpl
import br.com.lucasisrael.jetposemovies.moviesgenre.data.repository.MoviesFromGenreRepository
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
        moviesFromGenreRepository: MoviesFromGenreRepository,
    ): LoadGenresUseCase {
        return LoadGenresUseCaseImpl(genresRepository, moviesFromGenreRepository)
    }
}
