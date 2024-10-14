package br.com.lucasisrael.jetposemovies.details.data.repository

import android.os.Build
import androidx.annotation.RequiresExtension
import br.com.lucasisrael.jetposemovies.common.coroutines.safeApiCall
import br.com.lucasisrael.jetposemovies.common.models.Resource
import br.com.lucasisrael.jetposemovies.details.data.datasource.local.DetailsLocal
import br.com.lucasisrael.jetposemovies.details.data.datasource.remote.DetailsRemote
import br.com.lucasisrael.jetposemovies.details.data.mappers.toDetails
import br.com.lucasisrael.jetposemovies.details.data.mappers.toDetailsEntity
import br.com.lucasisrael.jetposemovies.details.data.models.domain.Details
import javax.inject.Inject

class DetailsRepositoryImpl @Inject constructor(
    private val detailsRemote: DetailsRemote,
    private val detailsLocal: DetailsLocal
): DetailsRepository {

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    override suspend fun getDetails(movieId: String): Resource<Details?> {
        return safeApiCall {
            refreshDetails(movieId)
            detailsLocal.getDetailsFromDataBase().toDetails()
        }
    }

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    override suspend fun refreshDetails(movieId: String) {
        safeApiCall {

            detailsLocal.saveDetailsToDataBase(
                detailsRemote.getDetailsById(movieId).toDetailsEntity()
            )
        }
    }

}
