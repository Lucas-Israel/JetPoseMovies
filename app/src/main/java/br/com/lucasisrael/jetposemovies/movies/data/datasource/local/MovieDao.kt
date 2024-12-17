package br.com.lucasisrael.jetposemovies.movies.data.datasource.local

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import br.com.lucasisrael.jetposemovies.movies.data.models.local.MovieEntity

@Dao
interface MovieDao {

    @Upsert
    fun upsert(list: List<MovieEntity>)

    @Query("SELECT * FROM movies WHERE genre_ids LIKE '%' || :genreId || '%' ORDER BY popularity")
    fun load(genreId: String): PagingSource<Int, MovieEntity>

    @Query("DELETE from movies")
    fun clearAll()
}
