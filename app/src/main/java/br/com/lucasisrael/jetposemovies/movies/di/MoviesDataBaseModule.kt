package br.com.lucasisrael.jetposemovies.movies.di

import android.content.Context
import androidx.room.Room
import br.com.lucasisrael.jetposemovies.movies.data.datasource.local.MovieDao
import br.com.lucasisrael.jetposemovies.movies.data.datasource.local.MoviesDataBase
import br.com.lucasisrael.jetposemovies.movies.data.datasource.local.PopularMoviesDao
import br.com.lucasisrael.jetposemovies.movies.data.datasource.local.UpcomingMoviesDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MoviesDataBaseModule {

    @Provides
    @Singleton
    fun provideMoviesDataBaseModule(@ApplicationContext appContext: Context): MoviesDataBase {
        return Room.databaseBuilder(
            appContext,
            MoviesDataBase::class.java,
            "jetpose_database"
        ).build()
    }

    @Provides
    @Singleton
    fun provideMoviesFromGenreDao(dataBase: MoviesDataBase): MovieDao {
        return dataBase.movieDao
    }

    @Provides
    @Singleton
    fun provideUpcomingDao(dataBase: MoviesDataBase): UpcomingMoviesDao {
        return dataBase.upcomingDao
    }

    @Provides
    @Singleton
    fun providePopularDao(dataBase: MoviesDataBase): PopularMoviesDao {
        return dataBase.popularDao
    }
}
