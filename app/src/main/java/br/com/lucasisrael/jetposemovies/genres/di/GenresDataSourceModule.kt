package br.com.lucasisrael.jetposemovies.genres.di

import br.com.lucasisrael.jetposemovies.genres.data.api.GenresApi
import br.com.lucasisrael.jetposemovies.genres.data.datasource.database.GenreDao
import br.com.lucasisrael.jetposemovies.genres.data.datasource.database.GenreDataBase
import br.com.lucasisrael.jetposemovies.genres.data.datasource.local.GenresLocal
import br.com.lucasisrael.jetposemovies.genres.data.datasource.local.GenresLocalImpl
import br.com.lucasisrael.jetposemovies.genres.data.datasource.remote.GenresRemote
import br.com.lucasisrael.jetposemovies.genres.data.datasource.remote.GenresRemoteImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object GenresDataSourceModule {

    @Provides
    @Singleton
    fun provideGenresRemoteDataSource(api: GenresApi): GenresRemote {
        return GenresRemoteImpl(api)
    }

    @Provides
    @Singleton
    fun provideGenresLocalDataSource(genreDao: GenreDao) : GenresLocal {
        return GenresLocalImpl(genreDao)
    }
 }
