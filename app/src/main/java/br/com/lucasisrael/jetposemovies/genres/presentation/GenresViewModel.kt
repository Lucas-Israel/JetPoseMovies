package br.com.lucasisrael.jetposemovies.genres.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.lucasisrael.jetposemovies.common.coroutines.CoroutinesProvider
import br.com.lucasisrael.jetposemovies.common.models.GenresWithImgUrl
import br.com.lucasisrael.jetposemovies.common.models.Resource
import br.com.lucasisrael.jetposemovies.genres.data.repository.GenresRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GenresViewModel @Inject constructor(
    private val repository: GenresRepository,
    private val coroutinesProvider: CoroutinesProvider
) : ViewModel() {

    private val _isLoading = MutableStateFlow(true)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    private val _genres =
        MutableStateFlow<List<GenresWithImgUrl>>(listOf())
    val genres: StateFlow<List<GenresWithImgUrl>> = _genres.asStateFlow()

    private var cachedGenresList = listOf<GenresWithImgUrl>()
    private var isSearchStarting = true


    init {
        getFromRepository()
    }

    fun searchGenres(query: String) {
        val listToSearch = if (isSearchStarting) {
            _genres.value
        } else {
            cachedGenresList
        }
        viewModelScope.launch(coroutinesProvider.default()) {
            if (query.isEmpty()) {
                _genres.value = cachedGenresList
                isSearchStarting = true
                return@launch
            }
            val results = listToSearch.filter {
                it.name.contains(query.trim(), ignoreCase = true)
            }
            if (isSearchStarting) {
                cachedGenresList = _genres.value
                isSearchStarting = false
            }
            _genres.value = results
        }
    }

    private fun getFromRepository() {
        viewModelScope.launch(coroutinesProvider.io()) {
            try {
                _isLoading.value = true
                when (val response = repository.getGenres()) {
                    is Resource.Success -> {
                        _genres.value = response.data!!
                    }

                    is Resource.Error -> {
                        _genres.value = listOf()
                    }
                }
            } catch (e: CancellationException) {
                e.printStackTrace()
            } finally {
                _isLoading.value = false
            }
        }
    }
}
