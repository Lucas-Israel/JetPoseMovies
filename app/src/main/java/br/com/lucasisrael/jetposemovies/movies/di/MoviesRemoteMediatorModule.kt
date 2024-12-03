package br.com.lucasisrael.jetposemovies.movies.di

import br.com.lucasisrael.jetposemovies.movies.data.api.MoviesApi
import br.com.lucasisrael.jetposemovies.movies.data.datasource.local.MoviesDataBase
import br.com.lucasisrael.jetposemovies.movies.data.datasource.remote.MoviesRemoteMediator
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MoviesRemoteMediatorModule {

    @Provides
    @Singleton
    fun provideMoviesRemoteMediator(
        moviesDataBase: MoviesDataBase,
        moviesApi: MoviesApi
    ): MoviesRemoteMediator {
        return MoviesRemoteMediator(movieDataBase = moviesDataBase, movieApi = moviesApi)
    }
}