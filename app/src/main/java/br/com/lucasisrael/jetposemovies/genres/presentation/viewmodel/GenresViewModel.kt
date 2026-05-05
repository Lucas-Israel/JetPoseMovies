package br.com.lucasisrael.jetposemovies.genres.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import br.com.lucasisrael.jetposemovies.genres.data.repository.GenresRepository
import br.com.lucasisrael.jetposemovies.genres.models.domain.GenreDomain
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class GenresViewModel @Inject constructor(
    repository: GenresRepository,
) : ViewModel() {
    var pagingFlow: Flow<PagingData<GenreDomain>> = repository.flow().cachedIn(viewModelScope)
}
