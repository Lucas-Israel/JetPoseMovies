package br.com.lucasisrael.jetposemovies.movies.di

import android.os.Build
import androidx.annotation.RequiresExtension
import br.com.lucasisrael.jetposemovies.movies.data.datasource.local.MoviesLocal
import br.com.lucasisrael.jetposemovies.movies.data.datasource.remote.MoviesRemote
import br.com.lucasisrael.jetposemovies.movies.data.repository.MoviesListRepository
import br.com.lucasisrael.jetposemovies.movies.data.repository.MoviesListRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MoviesRepositoryModule {

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    @Singleton
    @Provides
    fun provideMoviesFromGenreRepository(remote: MoviesRemote, local: MoviesLocal): MoviesListRepository {
        return MoviesListRepositoryImpl(remote, local)
    }
}
