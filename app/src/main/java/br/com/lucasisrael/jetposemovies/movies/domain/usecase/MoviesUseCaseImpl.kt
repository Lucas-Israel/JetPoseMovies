package br.com.lucasisrael.jetposemovies.movies.domain.usecase

import android.util.Log
import br.com.lucasisrael.jetposemovies.common.models.Resource
import br.com.lucasisrael.jetposemovies.movies.data.mappers.toMovieDomain
import br.com.lucasisrael.jetposemovies.movies.data.models.local.MovieEntity
import br.com.lucasisrael.jetposemovies.movies.data.models.remote.MovieDto
import br.com.lucasisrael.jetposemovies.movies.data.repository.MoviesListRepository
import br.com.lucasisrael.jetposemovies.movies.domain.models.MovieDomain
import kotlinx.coroutines.CancellationException
import javax.inject.Inject

class MoviesUseCaseImpl @Inject constructor(
    private val repository: MoviesListRepository
) : MoviesUseCase {

    override suspend fun getMoviesFromGenreRemote(genreId: String, page: Int): List<MovieDto?>? {
        return when (val response = repository.getMoviesFromGenreFromApi(genreId, page)) {
            is Resource.Success -> {
                response.data
            }

            is Resource.Error -> {
                listOf<MovieDto>()
            }
        }
    }

    override suspend fun saveMoviesFromGenreToDataBase(movies: MovieDto) {
        repository.saveMoviesFromGenreToDataBase(movies)
    }

    override suspend fun loadMoviesFromGenreFromDataBase(
        genreId: String,
        page: Int
    ): List<MovieEntity> {
        return repository.loadMoviesFromGenreFromDataBase()
    }

    override suspend fun getMoviesFromGenre(genreId: String, page: Int): List<MovieDomain> {
        return try {
            getMoviesFromGenreRemote(genreId, page)?.map {
                if (it != null) {
                    saveMoviesFromGenreToDataBase(it)
                }
            }
            loadMoviesFromGenreFromDataBase(genreId, page).map {
                it.toMovieDomain()
            }
        } catch (e: CancellationException) {
            Log.e(e.localizedMessage, e.message.toString())
            listOf<MovieDomain>()
        }
    }
}
