package br.com.lucasisrael.jetposemovies.genres.data.datasource.remote

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import br.com.lucasisrael.jetposemovies.common.database.JetPoseDataBase
import br.com.lucasisrael.jetposemovies.genres.data.api.GenresApi
import br.com.lucasisrael.jetposemovies.genres.data.mappers.toEntity
import br.com.lucasisrael.jetposemovies.genres.data.models.local.GenreEntity
import br.com.lucasisrael.jetposemovies.genres.data.models.response.GenreResponse
import coil.network.HttpException
import java.io.IOException

@OptIn(ExperimentalPagingApi::class)
class GenresRemoteMediator(
    private val dataBase: JetPoseDataBase,
    private val api: GenresApi,
) : RemoteMediator<Int, GenreEntity>() {
    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, GenreEntity>,
    ): MediatorResult {
        return try {

            val loadKey = getLoadKey(loadType, state)

            if (loadKey == -1) return MediatorResult.Success(endOfPaginationReached = true)

            val response = fetch(page = loadKey)

            dataBaseTransaction(loadType = loadType, response = response)

            // Currently the genres API result doesn't demand a pagination, if necessary in the future,
            // proper fetch pagination should be changed in this
            // MediatorResult.Success(endOfPaginationReached = bool logic here)
            MediatorResult.Success(endOfPaginationReached = true)

        } catch (e: IOException) {
            MediatorResult.Error(e)
        } catch (e: HttpException) {
            MediatorResult.Error(e)
        }
    }

    private fun getLoadKey(
        loadType: LoadType,
        state: PagingState<Int, GenreEntity>,
    ): Int {
        val loadKey = when (loadType) {
            LoadType.REFRESH -> 1
            LoadType.PREPEND -> -1
            LoadType.APPEND -> {
                val lastItem = state.lastItemOrNull()
                if (lastItem == null) {
                    1
                } else {
                    // Currently the genres API result doesn't demand a pagination, if necessary in the future,
                    // proper logic for finding next page should be done here with an Int
                    1
                }
            }
        }
        return loadKey
    }

    private suspend fun fetch(page: Int): GenreResponse {
        return api.fetch(page = page)
    }

    private suspend fun dataBaseTransaction(
        loadType: LoadType,
        response: GenreResponse,
    ) {
        val dao = dataBase.genresDao

        dataBase.withTransaction {
            if (loadType == LoadType.REFRESH) {
                dao.clearAll()
            }

            val entities = response.genres.map { it.toEntity() }
            dao.upsert(list = entities)
        }
    }
}