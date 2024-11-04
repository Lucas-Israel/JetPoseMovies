package br.com.lucasisrael.jetposemovies.movies.domain.usecase

import android.util.Log
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
    private val repository: MoviesListRepository
) : MoviesUseCase {

    override suspend fun fetchMovies(movieApiQuery: MovieApiQuery): List<MovieDto> {
        return when (val response = repository.fetchMovies(movieApiQuery)) {
            is Resource.Success -> {
                response.data!!.map { it }
            }

            is Resource.Error -> {
                listOf<MovieDto>()
            }
        }
    }

    override suspend fun saveMovies(movies: List<MovieDto>) {
        movies.forEach {
            repository.saveMoviesFromGenreToDataBase(it)
        }
    }

    override suspend fun loadMovies(searchType: SearchType): List<MovieEntity> {
        return repository.loadMoviesFromDataBase(searchType)
    }

    override suspend fun synchronizeMovies(searchType: SearchType, movieApiQuery: MovieApiQuery): List<MovieDomain> {
        return try {
            val data = fetchMovies(movieApiQuery)
            saveMovies(data)
            loadMovies(searchType).map { it.toMovieDomain() }
        } catch (e: CancellationException) {
            Log.e(e.localizedMessage, e.message.toString())
            listOf<MovieDomain>()
        }
    }
}
