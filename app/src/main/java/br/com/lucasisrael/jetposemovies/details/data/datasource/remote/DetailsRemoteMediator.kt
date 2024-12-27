package br.com.lucasisrael.jetposemovies.details.data.datasource.remote

import android.util.Log
import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import br.com.lucasisrael.jetposemovies.details.data.api.DetailsApi
import br.com.lucasisrael.jetposemovies.details.data.datasource.local.DetailsDao
import br.com.lucasisrael.jetposemovies.details.data.mappers.toDetailsEntity
import br.com.lucasisrael.jetposemovies.details.models.local.DetailsEntity
import br.com.lucasisrael.jetposemovies.details.models.remote.DetailsDto
import coil.network.HttpException
import java.io.IOException

const val LOCATION = "DetailsRemoteMediator ---"

@OptIn(ExperimentalPagingApi::class)
class DetailsRemoteMediator(
    private val dao: DetailsDao,
    private val api: DetailsApi
) : RemoteMediator<Int, DetailsEntity>(){

    init {
        Log.i(LOCATION, "***** INITIALIZING *****")
    }

    var movieId = 0

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, DetailsEntity>,
    ): MediatorResult {
        return try {

            Log.i(LOCATION, "----- Loop start -----")

            val response = fetch(movieId = movieId)

            saveToDataBase(loadType = loadType, response = response)

            MediatorResult.Success(endOfPaginationReached = true)
        } catch (e: IOException) {
            MediatorResult.Error(e)
        } catch (e: HttpException) {
            MediatorResult.Error(e)
        }
    }

    private suspend fun fetch(movieId: Int): DetailsDto {
        return api.fetch(movieId = movieId)
    }

    private fun saveToDataBase(
        loadType: LoadType,
        response: DetailsDto,
    ) {
        if (loadType == LoadType.REFRESH) {
            dao.clearAll()
        }

        dao.upsert(details = response.toDetailsEntity())
    }
}
