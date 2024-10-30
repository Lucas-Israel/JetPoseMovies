package br.com.lucasisrael.jetposemovies.moviesList.di

import br.com.lucasisrael.jetposemovies.moviesList.data.api.MoviesListApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MoviesListApiModule {

    @Singleton
    @Provides
    fun provideApiModule(retrofit: Retrofit): MoviesListApi {
        return retrofit.create(MoviesListApi::class.java)
    }
}
