package br.com.lucasisrael.jetposemovies.genres.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import br.com.lucasisrael.jetposemovies.genres.domain.models.GenreDomain
import br.com.lucasisrael.jetposemovies.genres.domain.usecase.GenresUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class GenresViewModel @Inject constructor(
    useCase: GenresUseCase,
) : ViewModel() {
    var pagingFlow: Flow<PagingData<GenreDomain>> = useCase.flow().cachedIn(viewModelScope)
}
