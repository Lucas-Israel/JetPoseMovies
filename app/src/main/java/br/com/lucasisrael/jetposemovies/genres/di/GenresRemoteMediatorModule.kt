package br.com.lucasisrael.jetposemovies.genres.di

import br.com.lucasisrael.jetposemovies.common.database.JetPoseDataBase
import br.com.lucasisrael.jetposemovies.genres.data.api.GenresApi
import br.com.lucasisrael.jetposemovies.genres.data.datasource.remote.GenresRemoteMediator
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object GenresRemoteMediatorModule {

    @Provides
    @Singleton
    fun provideGenresRepository(
        dataBase: JetPoseDataBase,
        api: GenresApi,
    ): GenresRemoteMediator {
        return GenresRemoteMediator(dataBase, api)
    }
}
