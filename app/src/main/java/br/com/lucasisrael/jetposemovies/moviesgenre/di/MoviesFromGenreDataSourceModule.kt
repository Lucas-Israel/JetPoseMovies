package br.com.lucasisrael.jetposemovies.moviesgenre.di

import br.com.lucasisrael.jetposemovies.moviesgenre.data.api.MoviesGenreApi
import br.com.lucasisrael.jetposemovies.moviesgenre.data.datasource.remote.MoviesFromGenreRemote
import br.com.lucasisrael.jetposemovies.moviesgenre.data.datasource.remote.MoviesFromGenreRemoteImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MoviesFromGenreDataSourceModule {

    @Singleton
    @Provides
    fun provideMoviesFromGenreDataSource(api: MoviesGenreApi) : MoviesFromGenreRemote {
        return MoviesFromGenreRemoteImpl(api)
    }
}
