package br.com.lucasisrael.jetposemovies.genres.domain.usecase

import android.util.Log
import br.com.lucasisrael.jetposemovies.common.models.Resource
import br.com.lucasisrael.jetposemovies.genres.data.mappers.toGenreWithUrl
import br.com.lucasisrael.jetposemovies.genres.data.models.local.GenreEntity
import br.com.lucasisrael.jetposemovies.genres.data.models.remote.GenreDto
import br.com.lucasisrael.jetposemovies.genres.data.repository.GenresRepository
import br.com.lucasisrael.jetposemovies.genres.domain.models.GenreWithImgUrl
import br.com.lucasisrael.jetposemovies.moviesgenre.data.repository.MoviesFromGenreRepository
import javax.inject.Inject
import kotlin.coroutines.cancellation.CancellationException

class LoadGenresUseCaseImpl @Inject constructor(
    private val genresRepository: GenresRepository,
    private val moviesFromGenreRepository: MoviesFromGenreRepository,
) : LoadGenresUseCase {

    override suspend fun getImageForGenre(genreId: Int): String? {
        return try {
            when (val response =
                moviesFromGenreRepository.getMoviesFromGenre(genreId.toString(), page = 1)) {
                is Resource.Success -> {
                    response.data?.results?.get(0)?.posterPath!!
                }

                is Resource.Error -> {
                    response.message.toString()
                }
            }
        } catch (e: CancellationException) {
            e.message.toString()
        }
    }

    override suspend fun saveGenresToDb(genres: List<GenreDto>) {
        genresRepository.saveGenresToDb(genres)
    }

    override suspend fun loadGenresFromDb(): List<GenreEntity> {
        return genresRepository.loadGenresFromDb()
    }

    override suspend fun createGenreWithImage(genre: GenreEntity): GenreWithImgUrl {
        val imageString = getImageForGenre(genre.id)
        return genre.toGenreWithUrl(imageString!!)
    }

    override suspend fun getGenres(): List<GenreWithImgUrl> {
        return try {
            when (val apiResponse = genresRepository.getGenresFromApi()) {

                is Resource.Success -> {
                    saveGenresToDb(apiResponse.data!!)
                    loadGenresFromDb().map {
                        createGenreWithImage(it)
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
