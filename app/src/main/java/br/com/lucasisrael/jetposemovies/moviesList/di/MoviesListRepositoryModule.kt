package br.com.lucasisrael.jetposemovies.moviesList.di

import android.os.Build
import androidx.annotation.RequiresExtension
import br.com.lucasisrael.jetposemovies.moviesList.data.datasource.local.MoviesListLocal
import br.com.lucasisrael.jetposemovies.moviesList.data.datasource.remote.MoviesListRemote
import br.com.lucasisrael.jetposemovies.moviesList.data.repository.MoviesListRepository
import br.com.lucasisrael.jetposemovies.moviesList.data.repository.MoviesListRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MoviesListRepositoryModule {

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    @Singleton
    @Provides
    fun provideMoviesFromGenreRepository(remote: MoviesListRemote, local: MoviesListLocal): MoviesListRepository {
        return MoviesListRepositoryImpl(remote, local)
    }
}
