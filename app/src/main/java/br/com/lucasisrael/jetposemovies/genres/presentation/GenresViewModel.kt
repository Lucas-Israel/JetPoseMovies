package br.com.lucasisrael.jetposemovies.genres.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.lucasisrael.jetposemovies.common.coroutines.CoroutinesProvider
import br.com.lucasisrael.jetposemovies.genres.domain.models.Genre
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

    private val _genres =
        MutableStateFlow<List<Genre>>(listOf())
    val genres: StateFlow<List<Genre>> = _genres.asStateFlow()

    init {
        loadGenres()
    }

    private fun loadGenres() {
        viewModelScope.launch(coroutinesProvider.io()) {
            try {
                _genres.value = genresUseCase.getGenres()

            } catch (e: CancellationException) {
                e.printStackTrace()
            }
        }
    }
}
