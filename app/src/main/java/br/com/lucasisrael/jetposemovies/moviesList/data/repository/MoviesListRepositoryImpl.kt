package br.com.lucasisrael.jetposemovies.moviesList.data.repository

import android.os.Build
import androidx.annotation.RequiresExtension
import br.com.lucasisrael.jetposemovies.common.coroutines.safeApiCall
import br.com.lucasisrael.jetposemovies.common.models.Resource
import br.com.lucasisrael.jetposemovies.moviesList.data.datasource.local.MoviesListLocal
import br.com.lucasisrael.jetposemovies.moviesList.data.datasource.remote.MoviesListRemote
import br.com.lucasisrael.jetposemovies.moviesList.data.models.local.MoviesListEntity
import br.com.lucasisrael.jetposemovies.moviesList.data.models.remote.MoviesListDto
import javax.inject.Inject

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
class MoviesListRepositoryImpl @Inject constructor(
    private val moviesRemote: MoviesListRemote,
    private val moviesLocal: MoviesListLocal,
) : MoviesListRepository {

    override suspend fun getMoviesFromGenreFromApi(
        genreId: String,
        page: Int
    ): Resource<MoviesListDto?> {
        return safeApiCall {
            moviesRemote.getMoviesFromGenre(genreId, page)
        }
    }

    override suspend fun saveMoviesFromGenreToDataBase(moviesListDto: MoviesListDto) {
        moviesLocal.saveMoviesFromGenreToDataBase(moviesListDto)
    }

    override suspend fun loadMoviesFromGenreFromDataBase(): MoviesListEntity {
        return moviesLocal.getMoviesFromGenreFromDataBase()
    }
}
