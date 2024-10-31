package br.com.lucasisrael.jetposemovies.movies.di

import android.content.Context
import androidx.room.Room
import br.com.lucasisrael.jetposemovies.movies.data.datasource.database.MoviesDao
import br.com.lucasisrael.jetposemovies.movies.data.datasource.database.MoviesDataBase
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
            "movies_from_genre_database"
        ).build()
    }

    @Provides
    fun provideMoviesFromGenreDao(dataBase: MoviesDataBase): MoviesDao {
        return dataBase.movieDao()
    }

}
