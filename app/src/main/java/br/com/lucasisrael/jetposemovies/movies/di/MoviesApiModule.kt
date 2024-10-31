package br.com.lucasisrael.jetposemovies.movies.di

import br.com.lucasisrael.jetposemovies.movies.data.api.MoviesApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MoviesApiModule {

    @Singleton
    @Provides
    fun provideApiModule(retrofit: Retrofit): MoviesApi {
        return retrofit.create(MoviesApi::class.java)
    }
}
