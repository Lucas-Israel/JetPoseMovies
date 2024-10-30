package br.com.lucasisrael.jetposemovies.moviesList.di

import android.content.Context
import androidx.room.Room
import br.com.lucasisrael.jetposemovies.moviesList.data.datasource.database.MoviesListDao
import br.com.lucasisrael.jetposemovies.moviesList.data.datasource.database.MoviesListDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MoviesListDataBaseModule {

    @Provides
    @Singleton
    fun provideMoviesDataBaseModule(@ApplicationContext appContext: Context): MoviesListDataBase {
        return Room.databaseBuilder(
            appContext,
            MoviesListDataBase::class.java,
            "movies_from_genre_database"
        ).build()
    }

    @Provides
    fun provideMoviesFromGenreDao(dataBase: MoviesListDataBase): MoviesListDao {
        return dataBase.movieDao()
    }

}
