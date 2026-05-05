package br.com.lucasisrael.jetposemovies.movies.di

import br.com.lucasisrael.jetposemovies.movies.data.api.MoviesApi
import br.com.lucasisrael.jetposemovies.movies.data.api.NowPlayingApi
import br.com.lucasisrael.jetposemovies.movies.data.api.PopularMoviesApi
import br.com.lucasisrael.jetposemovies.movies.data.api.TopRatedApi
import br.com.lucasisrael.jetposemovies.movies.data.api.UpcomingMoviesApi
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

    @Singleton
    @Provides
    fun provideUpcomingApiModule(retrofit: Retrofit): UpcomingMoviesApi {
        return retrofit.create(UpcomingMoviesApi::class.java)
    }

    @Singleton
    @Provides
    fun providePopularApiModule(retrofit: Retrofit): PopularMoviesApi {
        return retrofit.create(PopularMoviesApi::class.java)
    }

    @Singleton
    @Provides
    fun provideTopRatedApiModule(retrofit: Retrofit): TopRatedApi {
        return retrofit.create(TopRatedApi::class.java)
    }

    @Singleton
    @Provides
    fun provideNowPlayingApiModule(retrofit: Retrofit): NowPlayingApi {
        return retrofit.create(NowPlayingApi::class.java)
    }
}
