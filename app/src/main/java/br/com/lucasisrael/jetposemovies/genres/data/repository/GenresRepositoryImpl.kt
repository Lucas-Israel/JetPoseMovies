package br.com.lucasisrael.jetposemovies.genres.data.repository

import android.os.Build
import androidx.annotation.RequiresExtension
import br.com.lucasisrael.jetposemovies.common.corroutines.safeApiCall
import br.com.lucasisrael.jetposemovies.common.models.ClientResult
import br.com.lucasisrael.jetposemovies.genres.data.datasource.GenresDataSource
import br.com.lucasisrael.jetposemovies.genres.data.response.GenresResponse
import javax.inject.Inject

class GenresRepositoryImpl @Inject constructor(private val dataSource: GenresDataSource): GenresRepository {

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    override suspend fun getGenres(): ClientResult<GenresResponse> {
        return safeApiCall {
            dataSource.getGenres()
        }
    }
}
