package br.com.lucasisrael.jetposemovies.movies.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import br.com.lucasisrael.jetposemovies.movies.data.repository.TopRatedMoviesRepository
import br.com.lucasisrael.jetposemovies.movies.models.domain.MovieDomain
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class TopRatedMoviesViewModel @Inject constructor(
    useCase: TopRatedMoviesRepository,
) : ViewModel() {
    var pagingFlow: Flow<PagingData<MovieDomain>> = useCase.flow().cachedIn(viewModelScope)
}
