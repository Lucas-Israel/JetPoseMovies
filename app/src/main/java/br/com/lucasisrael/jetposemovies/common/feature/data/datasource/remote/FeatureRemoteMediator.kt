package br.com.lucasisrael.jetposemovies.common.feature.data.datasource.remote

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import br.com.lucasisrael.jetposemovies.common.feature.data.api.FeatureApi
import br.com.lucasisrael.jetposemovies.common.feature.data.datasource.local.FeatureDao
import br.com.lucasisrael.jetposemovies.common.feature.models.local.FeatureEntity
import br.com.lucasisrael.jetposemovies.common.feature.models.remote.FeatureDto
import coil.network.HttpException
import okio.IOException

@OptIn(ExperimentalPagingApi::class)
class FeatureRemoteMediator(
    private val dao: FeatureDao,
    private val api: FeatureApi,
) : RemoteMediator<Int, FeatureEntity>() {
    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, FeatureEntity>,
    ): MediatorResult {
        return try {
            val loadKey = getLoadKey(loadType = loadType, state = state)

            if (loadKey == -1) return MediatorResult.Success(endOfPaginationReached = true)

            val response = fetch()

            saveToDataBase(loadType = loadType, data = response)

            MediatorResult.Success(endOfPaginationReached = response.isEmpty())
        } catch (e: IOException) {
            MediatorResult.Error(e)
        } catch (e: HttpException) {
            MediatorResult.Error(e)
        }
    }

    private fun getLoadKey(
        loadType: LoadType,
        state: PagingState<Int, FeatureEntity>,
    ): Int {
        return when (loadType) {
            LoadType.REFRESH -> 1
            LoadType.PREPEND -> -1
            LoadType.APPEND -> {
                val lastItem = state.lastItemOrNull()
                if (lastItem == null) {
                    1
                } else {
                    getCount() / state.config.pageSize + 1
                }
            }
        }
    }

    private fun getCount(): Int {
        return dao.getCount()
    }

    suspend fun fetch(): List<FeatureDto> {
        return api.fetch()
    }

    private fun saveToDataBase(
        loadType: LoadType,
        data: List<FeatureDto>,
    ) {
        if (loadType == LoadType.REFRESH) {
            dao.clearAll()
        }
        dao.upsert(list = data)
    }

}
