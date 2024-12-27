package br.com.lucasisrael.jetposemovies.details.data.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import br.com.lucasisrael.jetposemovies.details.data.api.DetailsApi
import br.com.lucasisrael.jetposemovies.details.data.datasource.local.DetailsDao
import br.com.lucasisrael.jetposemovies.details.data.datasource.remote.DetailsRemoteMediator
import br.com.lucasisrael.jetposemovies.details.data.mappers.toDomain
import br.com.lucasisrael.jetposemovies.details.models.domain.DetailsDomain
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class DetailsRepository @Inject constructor(
    private val dao: DetailsDao,
    private val api: DetailsApi
){
    @OptIn(ExperimentalPagingApi::class)
    fun flow(movieId: Int): Flow<PagingData<DetailsDomain>> {
        val remoteMediator = DetailsRemoteMediator(dao = dao, api = api)

        remoteMediator.movieId = movieId

        return Pager(
            config = PagingConfig(pageSize = 20),
            remoteMediator = remoteMediator,
            pagingSourceFactory = { dao.load(movieId = movieId) }
        ).flow
            .map { pagingData -> pagingData.map { it.toDomain() } }
            .flowOn(Dispatchers.IO)
    }
}
