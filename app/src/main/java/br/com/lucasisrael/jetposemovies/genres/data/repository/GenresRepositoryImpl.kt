package br.com.lucasisrael.jetposemovies.genres.data.repository

import android.os.Build
import androidx.annotation.RequiresExtension
import br.com.lucasisrael.jetposemovies.common.coroutines.safeApiCall
import br.com.lucasisrael.jetposemovies.common.models.Resource
import br.com.lucasisrael.jetposemovies.genres.data.datasource.local.GenresLocal
import br.com.lucasisrael.jetposemovies.genres.data.datasource.remote.GenresRemote
import br.com.lucasisrael.jetposemovies.genres.data.mappers.toGenresEntity
import br.com.lucasisrael.jetposemovies.genres.data.models.local.GenreEntity
import br.com.lucasisrael.jetposemovies.genres.data.models.remote.GenreDto
import javax.inject.Inject

class GenresRepositoryImpl @Inject constructor(
    private val genresRemote: GenresRemote,
    private val genresLocal: GenresLocal
) : GenresRepository {

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    override suspend fun getGenresFromApi(): Resource<List<GenreDto>?> {
        return safeApiCall { genresRemote.getGenres() }
    }

    override suspend fun saveGenresToDb(genres: List<GenreDto>) {
        genresLocal.saveGenresToDataBase(genres.map { it.toGenresEntity() })
    }

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    override suspend fun loadGenresFromDb(): List<GenreEntity> {
        return genresLocal.getGenresFromDataBase()
    }
}
