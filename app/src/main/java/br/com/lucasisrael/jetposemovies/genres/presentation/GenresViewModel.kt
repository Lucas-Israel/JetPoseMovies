package br.com.lucasisrael.jetposemovies.genres.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.lucasisrael.jetposemovies.common.coroutines.CoroutinesProvider
import br.com.lucasisrael.jetposemovies.genres.domain.models.GenreWithImgUrl
import br.com.lucasisrael.jetposemovies.genres.domain.usecase.LoadGenresUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GenresViewModel @Inject constructor(
    private val genresUseCase: LoadGenresUseCase,
    private val coroutinesProvider: CoroutinesProvider
) : ViewModel() {

    private val _isLoading = MutableStateFlow(true)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    private val _genres =
        MutableStateFlow<List<GenreWithImgUrl>>(listOf())
    val genres: StateFlow<List<GenreWithImgUrl>> = _genres.asStateFlow()

    private var cachedGenresList = listOf<GenreWithImgUrl>()
    private var isSearchStarting = true

    init {
        loadGenres()
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

    private fun loadGenres() {
        viewModelScope.launch(coroutinesProvider.io()) {
            try {
                _isLoading.value = true
                _genres.value = genresUseCase.getGenres()

            } catch (e: CancellationException) {
                e.printStackTrace()
            } finally {
                _isLoading.value = false
            }
        }
    }
}
