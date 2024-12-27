package br.com.lucasisrael.jetposemovies.movies.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import br.com.lucasisrael.jetposemovies.movies.data.repository.MoviesRepository
import br.com.lucasisrael.jetposemovies.movies.models.domain.MovieDomain
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import javax.inject.Inject

@HiltViewModel
class MovieListViewModel @Inject constructor(
    private val moviesRepository: MoviesRepository,
) : ViewModel() {

    var pagingFlow: Flow<PagingData<MovieDomain>> = emptyFlow()

    fun setFlow(genreId: Int) {
        pagingFlow = moviesRepository.flow(genreId).cachedIn(viewModelScope)
    }
}
