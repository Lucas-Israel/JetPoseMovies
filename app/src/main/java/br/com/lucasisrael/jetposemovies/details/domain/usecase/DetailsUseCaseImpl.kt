package br.com.lucasisrael.jetposemovies.details.domain.usecase

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresExtension
import br.com.lucasisrael.jetposemovies.common.models.Resource
import br.com.lucasisrael.jetposemovies.details.data.mappers.toDetails
import br.com.lucasisrael.jetposemovies.details.data.models.local.DetailsEntity
import br.com.lucasisrael.jetposemovies.details.data.models.remote.DetailsDto
import br.com.lucasisrael.jetposemovies.details.data.repository.DetailsRepositoryImpl
import br.com.lucasisrael.jetposemovies.details.domain.models.Details
import javax.inject.Inject

class DetailsUseCaseImpl @Inject constructor(
    private val repositoryImpl: DetailsRepositoryImpl
) : DetailsUseCase {

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    override suspend fun invoke(movieId: String): Details {
        when (val apiResult = getDetailsApi(movieId)) {
            is Resource.Success -> {
                saveDetailsToDb(apiResult.data!!)
            }

            is Resource.Error -> {
                Log.e("Details UseCase ---", apiResult.message.toString())
            }
        }

        return loadDetailsFromDb(movieId).toDetails()
    }

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    private suspend fun getDetailsApi(movieId: String): Resource<DetailsDto?> {
        return repositoryImpl.getDetailsByIdFromApi(movieId)
    }

    private suspend fun saveDetailsToDb(details: DetailsDto) {
        repositoryImpl.saveDetailsToDb(details)
    }

    private suspend fun loadDetailsFromDb(movieId: String): DetailsEntity {
        return repositoryImpl.loadDetailsFromDb(movieId)
    }

}
