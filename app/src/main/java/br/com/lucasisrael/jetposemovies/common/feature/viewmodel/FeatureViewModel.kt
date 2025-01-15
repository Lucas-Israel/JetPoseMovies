package br.com.lucasisrael.jetposemovies.common.feature.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import br.com.lucasisrael.jetposemovies.common.feature.data.repository.FeatureRepository
import br.com.lucasisrael.jetposemovies.common.feature.models.domain.FeatureDomain
import kotlinx.coroutines.flow.Flow

class FeatureViewModel(
    repository: FeatureRepository,
) : ViewModel() {
    var pagingFlow: Flow<PagingData<FeatureDomain>> = repository.flow().cachedIn(viewModelScope)
}
