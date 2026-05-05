package br.com.lucasisrael.jetposemovies.genres.di

import br.com.lucasisrael.jetposemovies.genres.data.api.GenresApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object GenresApiModule {

    @Singleton
    @Provides
    fun provideApiModule(retrofit: Retrofit): GenresApi {
        return retrofit.create(GenresApi::class.java)
    }
}
