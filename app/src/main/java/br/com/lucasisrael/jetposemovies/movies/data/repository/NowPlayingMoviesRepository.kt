package br.com.lucasisrael.jetposemovies.movies.data.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import br.com.lucasisrael.jetposemovies.movies.data.api.NowPlayingApi
import br.com.lucasisrael.jetposemovies.movies.data.datasource.local.NowPlayingDao
import br.com.lucasisrael.jetposemovies.movies.data.datasource.remote.NowPlayingMoviesRemoteMediator
import br.com.lucasisrael.jetposemovies.movies.data.mappers.toDomain
import br.com.lucasisrael.jetposemovies.movies.models.domain.MovieDomain
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@OptIn(ExperimentalPagingApi::class)
class NowPlayingMoviesRepository @Inject constructor(
    private val dao: NowPlayingDao,
    private val api: NowPlayingApi,
) {
    fun flow(): Flow<PagingData<MovieDomain>> {
        val remoteMediator = NowPlayingMoviesRemoteMediator(dao = dao, api = api)

        return Pager(
            config = PagingConfig(pageSize = 20),
            remoteMediator = remoteMediator,
            pagingSourceFactory = { dao.load() }
        ).flow
            .map { pagingData -> pagingData.map { it.movie.toDomain() } }
            .flowOn(Dispatchers.IO)
    }
}
