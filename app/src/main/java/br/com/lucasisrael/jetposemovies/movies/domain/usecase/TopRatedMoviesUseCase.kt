package br.com.lucasisrael.jetposemovies.movies.domain.usecase

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import br.com.lucasisrael.jetposemovies.movies.data.datasource.remote.TopRatedRemoteMediator
import br.com.lucasisrael.jetposemovies.movies.data.mappers.toMovieDomain
import br.com.lucasisrael.jetposemovies.movies.data.repository.TopRatedMoviesRepository
import br.com.lucasisrael.jetposemovies.movies.domain.models.MovieDomain
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@OptIn(ExperimentalPagingApi::class)
class TopRatedMoviesUseCase @Inject constructor(
    private val repository: TopRatedMoviesRepository,
    private val remoteMediator: TopRatedRemoteMediator
){

    fun flow(): Flow<PagingData<MovieDomain>> {
        return Pager(
            config = PagingConfig(pageSize = 5),
            remoteMediator = remoteMediator,
            pagingSourceFactory = { repository.load() }
        ).flow.map { pagingData -> pagingData.map { it.movie.toMovieDomain() } }
    }

}
