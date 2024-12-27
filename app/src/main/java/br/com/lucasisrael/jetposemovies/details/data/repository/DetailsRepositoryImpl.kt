package br.com.lucasisrael.jetposemovies.details.data.repository

import android.os.Build
import androidx.annotation.RequiresExtension
import br.com.lucasisrael.jetposemovies.common.coroutines.safeApiCall
import br.com.lucasisrael.jetposemovies.common.models.Resource
import br.com.lucasisrael.jetposemovies.details.data.datasource.local.DetailsLocal
import br.com.lucasisrael.jetposemovies.details.data.datasource.remote.DetailsRemote
import br.com.lucasisrael.jetposemovies.details.data.mappers.toDetailsEntity
import br.com.lucasisrael.jetposemovies.details.data.models.local.DetailsEntity
import br.com.lucasisrael.jetposemovies.details.data.models.remote.DetailsDto
import javax.inject.Inject

class DetailsRepositoryImpl @Inject constructor(
    private val detailsRemote: DetailsRemote,
    private val detailsLocal: DetailsLocal
): DetailsRepository {

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    override suspend fun getDetailsByIdFromApi(movieId: String): DetailsDto? {
        return safeApiCall {
            detailsRemote.getDetailsById(movieId)
        }
    }

    override suspend fun saveDetailsToDb(detailsDto: DetailsDto) {
        detailsLocal.saveDetailsToDataBase(detailsDto.toDetailsEntity())
    }

    override suspend fun loadDetailsFromDb(movieId: String): DetailsEntity {
        return detailsLocal.getDetailsByMovieIdFromDataBase(movieId)
    }

}
