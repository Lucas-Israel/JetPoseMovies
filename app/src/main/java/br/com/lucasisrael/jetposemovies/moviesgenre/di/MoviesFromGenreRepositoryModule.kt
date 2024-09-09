package br.com.lucasisrael.jetposemovies.moviesgenre.di

import br.com.lucasisrael.jetposemovies.moviesgenre.data.datasource.MoviesFromGenreDataSource
import br.com.lucasisrael.jetposemovies.moviesgenre.data.repository.MoviesFromGenreRepository
import br.com.lucasisrael.jetposemovies.moviesgenre.data.repository.MoviesFromGenreRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MoviesFromGenreRepositoryModule {

    @Singleton
    @Provides
    fun provideMoviesFromGenreRepository(datasource: MoviesFromGenreDataSource): MoviesFromGenreRepository {
        return MoviesFromGenreRepositoryImpl(datasource)
    }
}
