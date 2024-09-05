package br.com.lucasisrael.jetposemovies.genres

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.lucasisrael.jetposemovies.common.models.Resource
import br.com.lucasisrael.jetposemovies.genres.data.repository.GenresRepository
import br.com.lucasisrael.jetposemovies.genres.data.response.GenresResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GenresViewModel @Inject constructor(private val repository: GenresRepository) : ViewModel() {

    private val _isLoading = MutableStateFlow(true)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    private val _genres = MutableStateFlow(GenresResponse(listOf()))
    val genres: StateFlow<GenresResponse> = _genres.asStateFlow()

    fun getFromRepository() {
        viewModelScope.launch {
            try {
                _isLoading.value = true
                when (val response = repository.getGenres()) {
                    is Resource.Success -> {
                        _genres.value = response.data!!
                        _isLoading.value = false
                    }

                    is Resource.Error -> {
                        _isLoading.value = false
                    }
                }
            } catch (e: CancellationException) {
                e.printStackTrace()
            }
        }
    }
}
