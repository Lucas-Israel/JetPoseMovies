package br.com.lucasisrael.jetposemovies.moviesgenre.data.repository

import android.os.Build
import androidx.annotation.RequiresExtension
import br.com.lucasisrael.jetposemovies.common.coroutines.safeApiCall
import br.com.lucasisrael.jetposemovies.common.models.Resource
import br.com.lucasisrael.jetposemovies.moviesgenre.data.datasource.local.MoviesFromGenreLocal
import br.com.lucasisrael.jetposemovies.moviesgenre.data.datasource.remote.MoviesFromGenreRemote
import br.com.lucasisrael.jetposemovies.moviesgenre.data.models.local.MoviesFromGenreEntity
import javax.inject.Inject

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
class MoviesFromGenreRepositoryImpl @Inject constructor(
    private val moviesRemote: MoviesFromGenreRemote,
    private val moviesLocal: MoviesFromGenreLocal,
) : MoviesFromGenreRepository {

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    override suspend fun getMoviesFromGenre(genreId: String, page: Int): Resource<MoviesFromGenreEntity?> {
        return safeApiCall {
            refreshMoviesFromGenre(genreId, page)
            return@safeApiCall moviesLocal.getMoviesFromGenreFromDataBase()
        }
    }

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    override suspend fun refreshMoviesFromGenre(genreId: String, page: Int) {
        safeApiCall {
            moviesLocal.saveMoviesFromGenreToDataBase(
                moviesRemote.getMoviesFromGenre(genreId, page)
            )
        }
    }
}
