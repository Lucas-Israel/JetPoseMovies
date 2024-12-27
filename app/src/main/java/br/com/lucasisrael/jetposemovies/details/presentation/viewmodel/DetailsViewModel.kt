package br.com.lucasisrael.jetposemovies.details.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import br.com.lucasisrael.jetposemovies.details.data.repository.DetailsRepository
import br.com.lucasisrael.jetposemovies.details.models.domain.DetailsDomain
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val repository: DetailsRepository,
) : ViewModel() {

    var pagingFlow: Flow<PagingData<DetailsDomain>> = emptyFlow()

    fun setFlow(movieId: Int) {
        pagingFlow = repository.flow(movieId = movieId).cachedIn(viewModelScope)
    }
}
