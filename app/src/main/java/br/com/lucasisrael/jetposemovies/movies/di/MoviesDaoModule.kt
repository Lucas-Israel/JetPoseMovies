package br.com.lucasisrael.jetposemovies.movies.di

import br.com.lucasisrael.jetposemovies.common.database.JetPoseDataBase
import br.com.lucasisrael.jetposemovies.movies.data.datasource.local.MovieDao
import br.com.lucasisrael.jetposemovies.movies.data.datasource.local.NowPlayingDao
import br.com.lucasisrael.jetposemovies.movies.data.datasource.local.PopularMoviesDao
import br.com.lucasisrael.jetposemovies.movies.data.datasource.local.TopRatedDao
import br.com.lucasisrael.jetposemovies.movies.data.datasource.local.UpcomingMoviesDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MoviesDaoModule {

    @Provides
    @Singleton
    fun provideMovieDao(dataBase: JetPoseDataBase): MovieDao {
        return dataBase.movieDao
    }

    @Provides
    @Singleton
    fun provideNowPlayingDao(dataBase: JetPoseDataBase): NowPlayingDao {
        return dataBase.nowPlayingDao
    }

    @Provides
    @Singleton
    fun providePopularDao(dataBase: JetPoseDataBase): PopularMoviesDao {
        return dataBase.popularDao
    }

    @Provides
    @Singleton
    fun provideTopRatedDao(dataBase: JetPoseDataBase): TopRatedDao {
        return dataBase.topRatedDao
    }

    @Provides
    @Singleton
    fun provideUpcoming(dataBase: JetPoseDataBase): UpcomingMoviesDao {
        return dataBase.upcomingDao
    }
}
