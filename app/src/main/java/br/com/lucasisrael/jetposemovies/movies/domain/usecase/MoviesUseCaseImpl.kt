package br.com.lucasisrael.jetposemovies.movies.domain.usecase

import android.util.Log
import androidx.paging.Pager
import br.com.lucasisrael.jetposemovies.common.models.Resource
import br.com.lucasisrael.jetposemovies.movies.data.datasource.local.SearchType
import br.com.lucasisrael.jetposemovies.movies.data.mappers.toMovieDomain
import br.com.lucasisrael.jetposemovies.movies.data.models.local.MovieEntity
import br.com.lucasisrael.jetposemovies.movies.data.models.query.MovieApiQuery
import br.com.lucasisrael.jetposemovies.movies.data.models.remote.MovieDto
import br.com.lucasisrael.jetposemovies.movies.data.repository.MoviesListRepository
import br.com.lucasisrael.jetposemovies.movies.domain.models.MovieDomain
import kotlinx.coroutines.CancellationException
import javax.inject.Inject

class MoviesUseCaseImpl @Inject constructor(
    pager: Pager<Int, MovieEntity>
) : MoviesUseCase {

//    override suspend fun fetchMovies(movieApiQuery: MovieApiQuery): List<MovieDto> {
//        return when (val response = repository.load(movieApiQuery)) {
//            is Resource.Success -> {
//                response.data!!.map { it }
//            }
//
//            is Resource.Error -> {
//                listOf<MovieDto>()
//            }
//        }
//    }
//
//    override suspend fun saveMovies(movies: List<MovieDto>) {
//        movies.forEach {
//            repository.saveMoviesFromGenreToDataBase(it)
//        }
//    }
//
//    override suspend fun loadMovies(searchType: SearchType): List<MovieEntity> {
//        return repository.loadMoviesFromDataBase(searchType)
//    }

    override suspend fun synchronizeMovies(searchType: SearchType): List<MovieDomain> {
        return try {
            val data = when (searchType) {
                is SearchType.GenreId -> {
                    val query = MovieApiQuery(genreId = searchType.genreId)
                    fetchMovies(query)
                }

                is SearchType.Popular -> {
                    val query = MovieApiQuery(sortBy = "popular.desc")
                    fetchMovies(query)
                }

                is SearchType.Upcoming -> {
                    val query = MovieApiQuery(
                        releaseDateLte = "{min_date}",
                        releaseType = 2 or 3,
                        releaseDateGte = "{max_date}",
                    )
                    fetchMovies(query)
                }
            }

            saveMovies(data)
            loadMovies(searchType).map { it.toMovieDomain() }
        } catch (e: CancellationException) {
            Log.e(e.localizedMessage, e.message.toString())
            listOf<MovieDomain>()
        }
    }
}
