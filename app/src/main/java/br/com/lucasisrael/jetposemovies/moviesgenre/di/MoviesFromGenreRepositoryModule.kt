package br.com.lucasisrael.jetposemovies.moviesgenre.di

import android.os.Build
import androidx.annotation.RequiresExtension
import br.com.lucasisrael.jetposemovies.moviesgenre.data.datasource.local.MoviesFromGenreLocal
import br.com.lucasisrael.jetposemovies.moviesgenre.data.datasource.remote.MoviesFromGenreRemote
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

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    @Singleton
    @Provides
    fun provideMoviesFromGenreRepository(remote: MoviesFromGenreRemote, local: MoviesFromGenreLocal): MoviesFromGenreRepository {
        return MoviesFromGenreRepositoryImpl(remote, local)
    }
}
