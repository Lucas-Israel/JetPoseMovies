package br.com.lucasisrael.jetposemovies.movies.di

import br.com.lucasisrael.jetposemovies.movies.data.api.MoviesApi
import br.com.lucasisrael.jetposemovies.movies.data.api.NowPlayingApi
import br.com.lucasisrael.jetposemovies.movies.data.api.PopularMoviesApi
import br.com.lucasisrael.jetposemovies.movies.data.api.TopRatedApi
import br.com.lucasisrael.jetposemovies.movies.data.api.UpcomingMoviesApi
import br.com.lucasisrael.jetposemovies.movies.data.datasource.local.MovieDao
import br.com.lucasisrael.jetposemovies.movies.data.datasource.local.NowPlayingDao
import br.com.lucasisrael.jetposemovies.movies.data.datasource.local.PopularMoviesDao
import br.com.lucasisrael.jetposemovies.movies.data.datasource.local.TopRatedDao
import br.com.lucasisrael.jetposemovies.movies.data.datasource.local.UpcomingMoviesDao
import br.com.lucasisrael.jetposemovies.movies.data.repository.MoviesRepository
import br.com.lucasisrael.jetposemovies.movies.data.repository.NowPlayingMoviesRepository
import br.com.lucasisrael.jetposemovies.movies.data.repository.PopularMoviesRepository
import br.com.lucasisrael.jetposemovies.movies.data.repository.TopRatedMoviesRepository
import br.com.lucasisrael.jetposemovies.movies.data.repository.UpcomingMoviesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MoviesRepositoryModule {

    @Provides
    @Singleton
    fun provideMoviesByGenreRepository(
        dao: MovieDao,
        api: MoviesApi,
    ): MoviesRepository {
        return MoviesRepository(dao, api)
    }

    @Provides
    @Singleton
    fun provideNowPlayingRepository(
        dao: NowPlayingDao,
        api: NowPlayingApi,
    ): NowPlayingMoviesRepository {
        return NowPlayingMoviesRepository(dao, api)
    }

    @Provides
    @Singleton
    fun providePopularRepository(
        dao: PopularMoviesDao,
        api: PopularMoviesApi,
    ): PopularMoviesRepository {
        return PopularMoviesRepository(dao, api)
    }

    @Provides
    @Singleton
    fun provideTopRatedRepository(
        dao: TopRatedDao,
        api: TopRatedApi,
    ): TopRatedMoviesRepository {
        return TopRatedMoviesRepository(dao, api)
    }

    @Provides
    @Singleton
    fun provideUpcomingRepository(
        dao: UpcomingMoviesDao,
        api: UpcomingMoviesApi,
    ): UpcomingMoviesRepository {
        return UpcomingMoviesRepository(dao, api)
    }
}
