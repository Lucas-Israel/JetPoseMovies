package br.com.lucasisrael.jetposemovies.movies.di

import br.com.lucasisrael.jetposemovies.movies.data.datasource.remote.MoviesRemoteMediator
import br.com.lucasisrael.jetposemovies.movies.data.datasource.remote.NowPlayingMoviesRemoteMediator
import br.com.lucasisrael.jetposemovies.movies.data.datasource.remote.PopularMoviesRemoteMediator
import br.com.lucasisrael.jetposemovies.movies.data.datasource.remote.TopRatedRemoteMediator
import br.com.lucasisrael.jetposemovies.movies.data.datasource.remote.UpcomingMoviesRemoteMediator
import br.com.lucasisrael.jetposemovies.movies.data.repository.MoviesRepository
import br.com.lucasisrael.jetposemovies.movies.data.repository.NowPlayingMoviesRepository
import br.com.lucasisrael.jetposemovies.movies.data.repository.PopularMoviesRepository
import br.com.lucasisrael.jetposemovies.movies.data.repository.TopRatedMoviesRepository
import br.com.lucasisrael.jetposemovies.movies.data.repository.UpcomingMoviesRepository
import br.com.lucasisrael.jetposemovies.movies.domain.usecase.MoviesUseCase
import br.com.lucasisrael.jetposemovies.movies.domain.usecase.NowPlayingMoviesUseCase
import br.com.lucasisrael.jetposemovies.movies.domain.usecase.PopularMoviesUseCase
import br.com.lucasisrael.jetposemovies.movies.domain.usecase.TopRatedMoviesUseCase
import br.com.lucasisrael.jetposemovies.movies.domain.usecase.UpcomingMoviesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MovieUseCaseModule {

    @Provides
    @Singleton
    fun provideMovieUseCase(
        moviesRepository: MoviesRepository,
        remoteMediator: MoviesRemoteMediator,
    ): MoviesUseCase {
        return MoviesUseCase(moviesRepository, remoteMediator)
    }

    @Provides
    @Singleton
    fun provideUpcomingUseCase(
        upcomingRepository: UpcomingMoviesRepository,
        remoteMediator: UpcomingMoviesRemoteMediator,
    ): UpcomingMoviesUseCase {
        return UpcomingMoviesUseCase(upcomingRepository, remoteMediator)
    }

    @Provides
    @Singleton
    fun providePopularUseCase(
        popularRepository: PopularMoviesRepository,
        remoteMediator: PopularMoviesRemoteMediator,
    ): PopularMoviesUseCase {
        return PopularMoviesUseCase(popularRepository, remoteMediator)
    }

    @Provides
    @Singleton
    fun provideTopRatedUseCase(
        topRatedMoviesRepository: TopRatedMoviesRepository,
        remoteMediator: TopRatedRemoteMediator,
    ): TopRatedMoviesUseCase {
        return TopRatedMoviesUseCase(topRatedMoviesRepository, remoteMediator)
    }

    @Provides
    @Singleton
    fun provideNowPlayingUseCase(
        nowPlayingMoviesRepository: NowPlayingMoviesRepository,
        remoteMediator: NowPlayingMoviesRemoteMediator,
    ): NowPlayingMoviesUseCase {
        return NowPlayingMoviesUseCase(nowPlayingMoviesRepository, remoteMediator)
    }
}