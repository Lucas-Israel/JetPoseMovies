package br.com.lucasisrael.jetposemovies.movies.di

import br.com.lucasisrael.jetposemovies.movies.data.api.MoviesApi
import br.com.lucasisrael.jetposemovies.movies.data.api.PopularMoviesApi
import br.com.lucasisrael.jetposemovies.movies.data.api.UpcomingMoviesApi
import br.com.lucasisrael.jetposemovies.movies.data.datasource.local.MoviesDataBase
import br.com.lucasisrael.jetposemovies.movies.data.datasource.remote.MoviesRemoteMediator
import br.com.lucasisrael.jetposemovies.movies.data.datasource.remote.PopularMoviesRemoteMediator
import br.com.lucasisrael.jetposemovies.movies.data.datasource.remote.UpcomingMoviesRemoteMediator
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
        moviesApi: MoviesApi,
    ): MoviesRemoteMediator {
        return MoviesRemoteMediator(moviesDataBase, moviesApi)
    }

    @Provides
    @Singleton
    fun provideUpcomingRemoteMediator(
        moviesDataBase: MoviesDataBase,
        api: UpcomingMoviesApi,
    ): UpcomingMoviesRemoteMediator {
        return UpcomingMoviesRemoteMediator(moviesDataBase, api)
    }

    @Provides
    @Singleton
    fun providePopularRemoteMediator(
        moviesDataBase: MoviesDataBase,
        api: PopularMoviesApi,
    ): PopularMoviesRemoteMediator {
        return PopularMoviesRemoteMediator(moviesDataBase, api)
    }
}