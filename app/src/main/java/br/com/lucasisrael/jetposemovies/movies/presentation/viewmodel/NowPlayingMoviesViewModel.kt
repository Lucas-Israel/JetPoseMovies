package br.com.lucasisrael.jetposemovies.movies.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import br.com.lucasisrael.jetposemovies.movies.domain.models.MovieDomain
import br.com.lucasisrael.jetposemovies.movies.domain.usecase.NowPlayingMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import javax.inject.Inject

@HiltViewModel
class NowPlayingMoviesViewModel @Inject constructor(
    private val useCase: NowPlayingMoviesUseCase,
) : ViewModel() {

    var pagingFlow: Flow<PagingData<MovieDomain>> = emptyFlow()

    fun setFlow() {
        pagingFlow = useCase.flow().cachedIn(viewModelScope)
    }
}
