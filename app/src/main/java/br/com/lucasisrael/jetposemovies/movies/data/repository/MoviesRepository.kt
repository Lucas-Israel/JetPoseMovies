package br.com.lucasisrael.jetposemovies.movies.data.repository

import androidx.paging.PagingSource
import br.com.lucasisrael.jetposemovies.common.utils.types.SearchType
import br.com.lucasisrael.jetposemovies.movies.data.datasource.local.MoviesDao
import br.com.lucasisrael.jetposemovies.movies.data.models.local.MovieEntity
import javax.inject.Inject

class MoviesRepository @Inject constructor(
    private val movieDao: MoviesDao,
) {
    fun load(searchType: SearchType): PagingSource<Int, MovieEntity> {
        return when (searchType) {
            is SearchType.GenreId -> movieDao.moviesByGenrePagingSource(searchType.genreId)
            is SearchType.Popular -> movieDao.popularMovies()
            is SearchType.Upcoming -> movieDao.upcomingMovies()
            is SearchType.TopRated -> movieDao.topRatedMovies()
        }
    }
}
