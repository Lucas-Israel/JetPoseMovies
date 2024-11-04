package br.com.lucasisrael.jetposemovies.details.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.lucasisrael.jetposemovies.common.coroutines.CoroutinesProvider
import br.com.lucasisrael.jetposemovies.details.domain.models.Details
import br.com.lucasisrael.jetposemovies.details.domain.usecase.DetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val useCase: DetailsUseCase,
    private val coroutinesProvider: CoroutinesProvider
) : ViewModel() {

    private val _isLoading = MutableStateFlow(true)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    private val _isError = MutableStateFlow(false)
    val isError: StateFlow<Boolean> = _isError

    private val _details = MutableStateFlow<Details>(Details())
    val details: StateFlow<Details> = _details.asStateFlow()

    fun getFromRepository(movieId: String) {
        viewModelScope.launch(coroutinesProvider.io()) {
            try {
                _isLoading.value = true
                _isError.value = false
                _details.value = useCase.invoke(movieId)

            } catch (e: CancellationException) {
                e.printStackTrace()
                _details.value = Details()
                _isError.value = true
            } finally {
                _isLoading.value = false
            }
        }
    }
}
