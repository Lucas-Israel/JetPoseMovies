package br.com.lucasisrael.jetposemovies.movies.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import br.com.lucasisrael.jetposemovies.common.utils.types.SearchType
import br.com.lucasisrael.jetposemovies.movies.domain.models.MovieDomain
import br.com.lucasisrael.jetposemovies.movies.domain.usecase.MoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

import javax.inject.Inject

@HiltViewModel
class MovieListViewModel @Inject constructor(
    private val moviesUseCase: MoviesUseCase
) : ViewModel() {

    var moviesByGenrePagingFlow: Flow<PagingData<MovieDomain>> = emptyFlow()
    var upcomingMoviesPagingFlow: Flow<PagingData<MovieDomain>> = emptyFlow()
    var popularMoviesPagingFlow: Flow<PagingData<MovieDomain>> = emptyFlow()
    var topRatedMoviesPagingFlow: Flow<PagingData<MovieDomain>> = emptyFlow()

    fun setMoviesFlow(searchType: SearchType) {

        val data = getFlow(searchType)

        when (searchType) {
            is SearchType.GenreId -> moviesByGenrePagingFlow = data
            is SearchType.Popular -> popularMoviesPagingFlow = data
            is SearchType.Upcoming -> upcomingMoviesPagingFlow = data
            is SearchType.TopRated -> topRatedMoviesPagingFlow = data
        }
    }

    private fun getFlow(searchType: SearchType): Flow<PagingData<MovieDomain>> {
        return moviesUseCase.moviesFlow(searchType).cachedIn(viewModelScope)
    }

}
