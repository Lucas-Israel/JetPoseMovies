package br.com.lucasisrael.jetposemovies.movies.data.datasource.local

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Upsert
import br.com.lucasisrael.jetposemovies.movies.data.models.local.MovieEntity

@Dao
interface MoviesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMoviesFromGenre(movie: MovieEntity)

    @Upsert
    suspend fun upsertAll(movies: List<MovieEntity>)

    @Delete
    suspend fun deleteMovieFromGenre(movieFromGenre: MovieEntity)

    @Query("DELETE from movies_from_genre")
    suspend fun clearAll()

    @Query(
        "SELECT * FROM movies_from_genre WHERE genre_ids LIKE '%' || :genreId || '%' ORDER BY popularity"
    )
    fun moviesByGenrePagingSource(genreId: String): PagingSource<Int, MovieEntity>

    @Query(
        "SELECT * from movies_from_genre ORDER BY popularity DESC"
    )
    fun popularMovies(): PagingSource<Int, MovieEntity>

    @Query(
        "SELECT * from movies_from_genre ORDER BY release_date DESC LIMIT 5"
    )
    fun upcomingMovies(): PagingSource<Int, MovieEntity>

    @Query(
        "SELECT * from movies_from_genre ORDER BY vote_average DESC"
    )
    fun topRatedMovies(): PagingSource<Int, MovieEntity>
}
