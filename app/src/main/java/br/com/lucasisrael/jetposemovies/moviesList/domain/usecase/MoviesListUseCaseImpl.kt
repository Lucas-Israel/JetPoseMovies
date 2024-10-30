package br.com.lucasisrael.jetposemovies.moviesList.domain.usecase

import android.util.Log
import br.com.lucasisrael.jetposemovies.common.models.Resource
import br.com.lucasisrael.jetposemovies.moviesList.data.mappers.toMoviesFromGenre
import br.com.lucasisrael.jetposemovies.moviesList.data.models.local.MoviesListEntity
import br.com.lucasisrael.jetposemovies.moviesList.data.models.remote.MoviesListDto
import br.com.lucasisrael.jetposemovies.moviesList.data.repository.MoviesListRepository
import br.com.lucasisrael.jetposemovies.moviesList.domain.models.MoviesList
import kotlinx.coroutines.CancellationException
import javax.inject.Inject

class MoviesListUseCaseImpl @Inject constructor(
    private val repository: MoviesListRepository
): MoviesListUseCase {

    override suspend fun getMoviesFromGenreRemote(genreId: String, page: Int): MoviesListDto {
        return when (val response = repository.getMoviesFromGenreFromApi(genreId,page)) {
            is Resource.Success -> {
                response.data!!
            }

            is Resource.Error -> {
                MoviesListDto(
                    0, listOf(), 0, 0
                )
            }
        }
    }

    override suspend fun saveMoviesFromGenreToDataBase(movies: MoviesListDto) {
        repository.saveMoviesFromGenreToDataBase(movies)
    }

    override suspend fun loadMoviesFromGenreFromDataBase(
        genreId: String,
        page: Int
    ): MoviesListEntity {
        return repository.loadMoviesFromGenreFromDataBase()
    }

    override suspend fun getMoviesFromGenre(genreId: String, page: Int): MoviesList {
        return try {
            val resultDto = getMoviesFromGenreRemote(genreId, page)
            saveMoviesFromGenreToDataBase(resultDto)
            loadMoviesFromGenreFromDataBase(genreId, page).toMoviesFromGenre()
        } catch (e : CancellationException) {
            Log.e(e.localizedMessage, e.message.toString())
            MoviesList(0, listOf(), 0, 0)
        }
    }
}
