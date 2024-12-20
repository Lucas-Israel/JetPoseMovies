package br.com.lucasisrael.jetposemovies.movies.data.datasource.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import br.com.lucasisrael.jetposemovies.common.converters.ListConverters
import br.com.lucasisrael.jetposemovies.movies.data.models.local.MovieEntity
import br.com.lucasisrael.jetposemovies.movies.data.models.local.NowPlayingMoviesEntity
import br.com.lucasisrael.jetposemovies.movies.data.models.local.PopularMoviesEntity
import br.com.lucasisrael.jetposemovies.movies.data.models.local.TopRatedMoviesEntity
import br.com.lucasisrael.jetposemovies.movies.data.models.local.UpcomingMoviesEntity

@Database(
    entities = [
        MovieEntity::class,
        UpcomingMoviesEntity::class,
        PopularMoviesEntity::class,
        TopRatedMoviesEntity::class,
        NowPlayingMoviesEntity::class
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(
    ListConverters::class
)
abstract class MoviesDataBase : RoomDatabase() {
    abstract val movieDao: MovieDao
    abstract val upcomingDao: UpcomingMoviesDao
    abstract val popularDao: PopularMoviesDao
    abstract val topRatedDao: TopRatedDao
    abstract val nowPLayingDao: NowPlayingDao
}
