package br.com.lucasisrael.jetposemovies.common.database

import androidx.room.Database
import androidx.room.RoomDatabase
import br.com.lucasisrael.jetposemovies.details.data.datasource.local.DetailsDao
import br.com.lucasisrael.jetposemovies.details.models.local.DetailsEntity
import br.com.lucasisrael.jetposemovies.genres.data.datasource.local.GenresDao
import br.com.lucasisrael.jetposemovies.genres.models.local.GenreEntity
import br.com.lucasisrael.jetposemovies.movies.data.datasource.local.MovieDao
import br.com.lucasisrael.jetposemovies.movies.data.datasource.local.NowPlayingDao
import br.com.lucasisrael.jetposemovies.movies.data.datasource.local.PopularMoviesDao
import br.com.lucasisrael.jetposemovies.movies.data.datasource.local.TopRatedDao
import br.com.lucasisrael.jetposemovies.movies.data.datasource.local.UpcomingMoviesDao
import br.com.lucasisrael.jetposemovies.movies.models.local.MovieEntity
import br.com.lucasisrael.jetposemovies.movies.models.local.MovieGenreIdsEntity
import br.com.lucasisrael.jetposemovies.movies.models.local.NowPlayingMovieEntity
import br.com.lucasisrael.jetposemovies.movies.models.local.PopularMoviesEntity
import br.com.lucasisrael.jetposemovies.movies.models.local.TopRatedMoviesEntity
import br.com.lucasisrael.jetposemovies.movies.models.local.UpcomingMoviesEntity

@Database(
    entities = [
        MovieEntity::class,
        UpcomingMoviesEntity::class,
        PopularMoviesEntity::class,
        TopRatedMoviesEntity::class,
        NowPlayingMovieEntity::class,
        GenreEntity::class,
        MovieGenreIdsEntity::class,
        DetailsEntity::class,
    ],
    version = 1,
    exportSchema = false
)
abstract class JetPoseDataBase : RoomDatabase() {
    abstract val movieDao: MovieDao
    abstract val upcomingDao: UpcomingMoviesDao
    abstract val popularDao: PopularMoviesDao
    abstract val topRatedDao: TopRatedDao
    abstract val nowPlayingDao: NowPlayingDao
    abstract val genresDao: GenresDao
    abstract val detailsDao: DetailsDao
}
