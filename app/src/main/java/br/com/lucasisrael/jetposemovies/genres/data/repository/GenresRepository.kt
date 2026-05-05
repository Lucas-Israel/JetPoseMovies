package br.com.lucasisrael.jetposemovies.genres.data.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import br.com.lucasisrael.jetposemovies.genres.data.api.GenresApi
import br.com.lucasisrael.jetposemovies.genres.data.datasource.local.GenresDao
import br.com.lucasisrael.jetposemovies.genres.data.datasource.remote.GenresRemoteMediator
import br.com.lucasisrael.jetposemovies.genres.data.mappers.toDomain
import br.com.lucasisrael.jetposemovies.genres.models.domain.GenreDomain
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GenresRepository @Inject constructor(
    private val dao: GenresDao,
    private val api: GenresApi,
) {
    @OptIn(ExperimentalPagingApi::class)
    fun flow(): Flow<PagingData<GenreDomain>> {
        val remoteMediator = GenresRemoteMediator(dao = dao, api = api)

        return Pager(
            config = PagingConfig(pageSize = 20),
            remoteMediator = remoteMediator,
            pagingSourceFactory = { dao.load() }
        ).flow
            .map { pagingData -> pagingData.map { it.toDomain() } }
            .flowOn(Dispatchers.IO)
    }
}
