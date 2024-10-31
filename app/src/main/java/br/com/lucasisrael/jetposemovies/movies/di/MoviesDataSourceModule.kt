package br.com.lucasisrael.jetposemovies.movies.di

import br.com.lucasisrael.jetposemovies.movies.data.api.MoviesApi
import br.com.lucasisrael.jetposemovies.movies.data.datasource.database.MoviesDao
import br.com.lucasisrael.jetposemovies.movies.data.datasource.local.MoviesLocal
import br.com.lucasisrael.jetposemovies.movies.data.datasource.local.MoviesLocalImpl
import br.com.lucasisrael.jetposemovies.movies.data.datasource.remote.MoviesRemote
import br.com.lucasisrael.jetposemovies.movies.data.datasource.remote.MoviesRemoteImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MoviesDataSourceModule {

    @Singleton
    @Provides
    fun provideMoviesFromGenreRemoteDataSource(api: MoviesApi) : MoviesRemote {
        return MoviesRemoteImpl(api)
    }

    @Singleton
    @Provides
    fun provideMoviesFromGenreLocalDataSource(dao: MoviesDao) : MoviesLocal {
        return MoviesLocalImpl(dao)
    }
}
