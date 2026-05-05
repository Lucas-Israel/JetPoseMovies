package br.com.lucasisrael.jetposemovies.genres.data.datasource.remote

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import br.com.lucasisrael.jetposemovies.genres.data.api.GenresApi
import br.com.lucasisrael.jetposemovies.genres.data.datasource.local.GenresDao
import br.com.lucasisrael.jetposemovies.genres.data.mappers.toEntity
import br.com.lucasisrael.jetposemovies.genres.models.local.GenreEntity
import br.com.lucasisrael.jetposemovies.genres.models.response.GenreResponse
import coil.network.HttpException
import java.io.IOException

@OptIn(ExperimentalPagingApi::class)
class GenresRemoteMediator(
    private val dao: GenresDao,
    private val api: GenresApi,
) : RemoteMediator<Int, GenreEntity>() {

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, GenreEntity>,
    ): MediatorResult {
        return try {

            val loadKey = getLoadKey(loadType = loadType, state = state)

            if (loadKey == -1) return MediatorResult.Success(endOfPaginationReached = true)

            val response = fetch(page = loadKey)

            saveToDataBase(loadType = loadType, response = response)

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
                    1
                }
            }
        }
        return loadKey
    }

    private suspend fun fetch(page: Int): GenreResponse {
        return api.fetch(page = page)
    }

    private fun saveToDataBase(
        loadType: LoadType,
        response: GenreResponse,
    ) {
        if (loadType == LoadType.REFRESH) {
            dao.clearAll()
        }

        dao.upsert(list = response.genres.map { it.toEntity() })
    }
}