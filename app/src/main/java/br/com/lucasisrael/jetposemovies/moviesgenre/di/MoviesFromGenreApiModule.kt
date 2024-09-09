package br.com.lucasisrael.jetposemovies.moviesgenre.di

import br.com.lucasisrael.jetposemovies.moviesgenre.data.api.MoviesGenreApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MoviesFromGenreApiModule {

    @Singleton
    @Provides
    fun provideApiModule(retrofit: Retrofit): MoviesGenreApi {
        return retrofit.create(MoviesGenreApi::class.java)
    }
}
