package br.com.lucasisrael.jetposemovies.common.feature.data.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import br.com.lucasisrael.jetposemovies.common.feature.data.api.FeatureApi
import br.com.lucasisrael.jetposemovies.common.feature.data.datasource.local.FeatureDao
import br.com.lucasisrael.jetposemovies.common.feature.data.datasource.remote.FeatureRemoteMediator
import br.com.lucasisrael.jetposemovies.common.feature.models.domain.FeatureDomain
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map

class FeatureRepository(
    private val dao: FeatureDao,
    private val api: FeatureApi,
) {

    @OptIn(ExperimentalPagingApi::class)
    fun flow(): Flow<PagingData<FeatureDomain>> {
        val remoteMediator = FeatureRemoteMediator(dao = dao, api = api)

        return Pager(
            config = PagingConfig(pageSize = 20),
            remoteMediator = remoteMediator,
            pagingSourceFactory = { dao.load() }
        ).flow
            .map { pagingData -> pagingData.map { it.toDomain() } }
            .flowOn(Dispatchers.IO)
    }
}
