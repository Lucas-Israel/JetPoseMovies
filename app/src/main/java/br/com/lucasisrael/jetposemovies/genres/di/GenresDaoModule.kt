package br.com.lucasisrael.jetposemovies.genres.di

import br.com.lucasisrael.jetposemovies.common.database.JetPoseDataBase
import br.com.lucasisrael.jetposemovies.genres.data.datasource.local.GenresDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object GenresDaoModule {

    @Provides
    @Singleton
    fun provideGenreDao(dataBase: JetPoseDataBase): GenresDao {
        return dataBase.genresDao
    }
}
