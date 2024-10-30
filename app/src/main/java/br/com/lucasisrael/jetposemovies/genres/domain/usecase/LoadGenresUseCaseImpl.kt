package br.com.lucasisrael.jetposemovies.genres.domain.usecase

import android.util.Log
import br.com.lucasisrael.jetposemovies.common.models.Resource
import br.com.lucasisrael.jetposemovies.genres.data.mappers.toGenres
import br.com.lucasisrael.jetposemovies.genres.data.models.local.GenreEntity
import br.com.lucasisrael.jetposemovies.genres.data.models.remote.GenreDto
import br.com.lucasisrael.jetposemovies.genres.data.repository.GenresRepository
import br.com.lucasisrael.jetposemovies.genres.domain.models.Genre
import javax.inject.Inject
import kotlin.coroutines.cancellation.CancellationException

class LoadGenresUseCaseImpl @Inject constructor(
    private val genresRepository: GenresRepository,
) : LoadGenresUseCase {

    override suspend fun saveGenresToDb(genres: List<GenreDto>) {
        genresRepository.saveGenresToDb(genres)
    }

    override suspend fun loadGenresFromDb(): List<GenreEntity> {
        return genresRepository.loadGenresFromDb()
    }

    override suspend fun getGenres(): List<Genre> {
        return try {
            when (val apiResponse = genresRepository.getGenresFromApi()) {

                is Resource.Success -> {
                    saveGenresToDb(apiResponse.data!!)
                    loadGenresFromDb().map {
                        it.toGenres()
                    }
                }

                is Resource.Error -> {
                    listOf()
                }
            }

        } catch (e: CancellationException) {
            Log.e(e.localizedMessage, e.message.toString())
            listOf()
        }
    }
}
