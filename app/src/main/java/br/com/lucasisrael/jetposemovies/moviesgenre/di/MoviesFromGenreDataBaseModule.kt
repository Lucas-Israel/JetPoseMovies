package br.com.lucasisrael.jetposemovies.moviesgenre.di

import android.content.Context
import androidx.room.Room
import androidx.room.withTransaction
import br.com.lucasisrael.jetposemovies.moviesgenre.data.datasource.database.MoviesFromGenreDao
import br.com.lucasisrael.jetposemovies.moviesgenre.data.datasource.database.MoviesFromGenreDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MoviesFromGenreDataBaseModule {

    @Provides
    @Singleton
    fun provideMoviesDataBaseModule(@ApplicationContext appContext: Context): MoviesFromGenreDataBase {
        return Room.databaseBuilder(
            appContext,
            MoviesFromGenreDataBase::class.java,
            "movies_from_genre_database"
        ).build()
    }

    @Provides
    fun provideMoviesFromGenreDao(dataBase: MoviesFromGenreDataBase): MoviesFromGenreDao {
        return dataBase.movieDao()
    }

}
