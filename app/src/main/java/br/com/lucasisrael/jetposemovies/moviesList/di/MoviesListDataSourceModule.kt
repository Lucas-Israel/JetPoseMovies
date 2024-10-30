package br.com.lucasisrael.jetposemovies.moviesList.di

import br.com.lucasisrael.jetposemovies.moviesList.data.api.MoviesListApi
import br.com.lucasisrael.jetposemovies.moviesList.data.datasource.database.MoviesListDao
import br.com.lucasisrael.jetposemovies.moviesList.data.datasource.local.MoviesListLocal
import br.com.lucasisrael.jetposemovies.moviesList.data.datasource.local.MoviesListLocalImpl
import br.com.lucasisrael.jetposemovies.moviesList.data.datasource.remote.MoviesListRemote
import br.com.lucasisrael.jetposemovies.moviesList.data.datasource.remote.MoviesListRemoteImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MoviesListDataSourceModule {

    @Singleton
    @Provides
    fun provideMoviesFromGenreRemoteDataSource(api: MoviesListApi) : MoviesListRemote {
        return MoviesListRemoteImpl(api)
    }

    @Singleton
    @Provides
    fun provideMoviesFromGenreLocalDataSource(dao: MoviesListDao) : MoviesListLocal {
        return MoviesListLocalImpl(dao)
    }
}
