package br.com.lucasisrael.jetposemovies.movies.domain.usecase

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import br.com.lucasisrael.jetposemovies.movies.data.datasource.remote.NowPlayingMoviesRemoteMediator
import br.com.lucasisrael.jetposemovies.movies.data.mappers.toMovieDomain
import br.com.lucasisrael.jetposemovies.movies.data.repository.NowPlayingMoviesRepository
import br.com.lucasisrael.jetposemovies.movies.domain.models.MovieDomain
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class NowPlayingMoviesUseCase @Inject constructor(
    private val repository: NowPlayingMoviesRepository,
    private val remoteMediator: NowPlayingMoviesRemoteMediator
) {

    @OptIn(ExperimentalPagingApi::class)
    fun flow(): Flow<PagingData<MovieDomain>> {
        return Pager(
            config = PagingConfig(pageSize = 20),
            remoteMediator = remoteMediator,
            pagingSourceFactory = { repository.load() }
        ).flow.map { pagingData -> pagingData.map { it.movie.toMovieDomain() } }
    }
}
