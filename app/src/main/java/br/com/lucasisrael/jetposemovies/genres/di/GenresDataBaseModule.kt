package br.com.lucasisrael.jetposemovies.genres.di

import android.content.Context
import androidx.room.Room
import br.com.lucasisrael.jetposemovies.genres.data.datasource.database.GenreDao
import br.com.lucasisrael.jetposemovies.genres.data.datasource.database.GenreDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object GenresDataBaseModule {

    @Provides
    @Singleton
    fun provideGenreDataBase(@ApplicationContext appContext: Context): GenreDataBase {
        return Room.databaseBuilder(
            appContext,
            GenreDataBase::class.java,
            "genre_database"
        ).build()
    }

    @Provides
    fun provideGenreDao(dataBase: GenreDataBase): GenreDao {
        return dataBase.genreDao()
    }
}
