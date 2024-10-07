package br.com.lucasisrael.jetposemovies.moviesgenre.data.repository

import android.os.Build
import androidx.annotation.RequiresExtension
import br.com.lucasisrael.jetposemovies.common.coroutines.safeApiCall
import br.com.lucasisrael.jetposemovies.common.models.Resource
import br.com.lucasisrael.jetposemovies.moviesgenre.data.datasource.MoviesFromGenreDataSource
import br.com.lucasisrael.jetposemovies.moviesgenre.data.response.MoviesFromGenreResponse
import javax.inject.Inject

class MoviesFromGenreRepositoryImpl @Inject constructor(
    private val dataSource: MoviesFromGenreDataSource,
) :
    MoviesFromGenreRepository {
    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    override suspend fun getMoviesFromGenre(id: String, page: Int): Resource<MoviesFromGenreResponse?> {
        return safeApiCall {
            dataSource.getMoviesFromGenre(id, page)
        }
    }
}
