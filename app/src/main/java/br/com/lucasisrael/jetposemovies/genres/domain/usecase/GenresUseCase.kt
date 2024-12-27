package br.com.lucasisrael.jetposemovies.genres.domain.usecase

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import br.com.lucasisrael.jetposemovies.genres.data.datasource.remote.GenresRemoteMediator
import br.com.lucasisrael.jetposemovies.genres.data.mappers.toDomain
import br.com.lucasisrael.jetposemovies.genres.data.repository.GenresRepository
import br.com.lucasisrael.jetposemovies.genres.domain.models.GenreDomain
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GenresUseCase @Inject constructor(
    private val repository: GenresRepository,
    private val remoteMediator: GenresRemoteMediator,
) {

    @OptIn(ExperimentalPagingApi::class)
    fun flow(): Flow<PagingData<GenreDomain>> {
        return Pager(
            config = PagingConfig(pageSize = 20),
            remoteMediator = remoteMediator,
            pagingSourceFactory = { repository.load() }
        ).flow.map { pagingData -> pagingData.map { it.toDomain() } }.flowOn(Dispatchers.IO)
    }
}
