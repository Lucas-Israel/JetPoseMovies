package br.com.lucasisrael.jetposemovies.moviesgenre.data.repository

import android.os.Build
import androidx.annotation.RequiresExtension
import br.com.lucasisrael.jetposemovies.common.coroutines.safeApiCall
import br.com.lucasisrael.jetposemovies.common.models.Resource
import br.com.lucasisrael.jetposemovies.moviesgenre.data.datasource.local.MoviesFromGenreLocal
import br.com.lucasisrael.jetposemovies.moviesgenre.data.datasource.remote.MoviesFromGenreRemote
import br.com.lucasisrael.jetposemovies.moviesgenre.data.models.local.MoviesFromGenreEntity
import br.com.lucasisrael.jetposemovies.moviesgenre.data.models.remote.MoviesFromGenreDto
import javax.inject.Inject

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
class MoviesFromGenreRepositoryImpl @Inject constructor(
    private val moviesRemote: MoviesFromGenreRemote,
    private val moviesLocal: MoviesFromGenreLocal,
) : MoviesFromGenreRepository {

    override suspend fun getMoviesFromGenreFromApi(
        genreId: String,
        page: Int
    ): Resource<MoviesFromGenreDto?> {
        return safeApiCall {
            moviesRemote.getMoviesFromGenre(genreId, page)
        }
    }

    override suspend fun saveMoviesFromGenreToDataBase(moviesFromGenreDto: MoviesFromGenreDto) {
        moviesLocal.saveMoviesFromGenreToDataBase(moviesFromGenreDto)
    }

    override suspend fun loadMoviesFromGenreFromDataBase(): MoviesFromGenreEntity {
        return moviesLocal.getMoviesFromGenreFromDataBase()
    }
}
