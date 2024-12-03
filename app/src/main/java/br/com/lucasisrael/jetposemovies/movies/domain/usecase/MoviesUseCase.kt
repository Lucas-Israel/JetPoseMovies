package br.com.lucasisrael.jetposemovies.movies.domain.usecase

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import br.com.lucasisrael.jetposemovies.common.utils.types.SearchType
import br.com.lucasisrael.jetposemovies.movies.data.datasource.remote.MoviesRemoteMediator
import br.com.lucasisrael.jetposemovies.movies.data.mappers.toMovieDomain
import br.com.lucasisrael.jetposemovies.movies.data.repository.MoviesRepository
import br.com.lucasisrael.jetposemovies.movies.domain.models.MovieDomain
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@OptIn(ExperimentalPagingApi::class)
class MoviesUseCase @Inject constructor(
    private val moviesRepository: MoviesRepository,
    private val remoteMediator: MoviesRemoteMediator
) {
    fun moviesFlow(searchType: SearchType): Flow<PagingData<MovieDomain>> {

        remoteMediator.searchType = searchType

        return Pager(
            config = PagingConfig(pageSize = 20),
            remoteMediator = remoteMediator,
            pagingSourceFactory = { moviesRepository.load(searchType)}
        ).flow.map { pagingData -> pagingData.map { it.toMovieDomain() } }
    }
}
