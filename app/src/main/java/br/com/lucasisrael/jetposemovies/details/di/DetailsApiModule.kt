package br.com.lucasisrael.jetposemovies.details.di

import br.com.lucasisrael.jetposemovies.details.data.api.DetailsApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DetailsApiModule {

    @Singleton
    @Provides
    fun provideApiModule(retrofit: Retrofit): DetailsApi {
        return retrofit.create(DetailsApi::class.java)
    }
}
