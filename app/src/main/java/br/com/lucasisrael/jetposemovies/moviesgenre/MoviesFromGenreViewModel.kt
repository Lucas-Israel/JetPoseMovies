package br.com.lucasisrael.jetposemovies.moviesgenre

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.lucasisrael.jetposemovies.common.coroutines.CoroutinesProvider
import br.com.lucasisrael.jetposemovies.common.models.Resource
import br.com.lucasisrael.jetposemovies.moviesgenre.data.repository.MoviesFromGenreRepository
import br.com.lucasisrael.jetposemovies.moviesgenre.data.response.MoviesFromGenreResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoviesFromGenreViewModel @Inject constructor(
    private val repository: MoviesFromGenreRepository,
    private val coroutinesProvider: CoroutinesProvider
) :
    ViewModel() {

    private val _isLoading = MutableStateFlow(true)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    private val _moviesFromGenre = MutableStateFlow(MoviesFromGenreResponse(0, listOf(), 0, 0))
    val moviesFromGenre: StateFlow<MoviesFromGenreResponse> = _moviesFromGenre.asStateFlow()

    fun getMoviesFromGenreRepository(genreId: String) {
        viewModelScope.launch(coroutinesProvider.io()) {
            try {
                _isLoading.value = true
                when (val response = repository.getMoviesFromGenre(genreId)) {
                    is Resource.Success -> {
                        _moviesFromGenre.value = response.data!!
                    }

                    is Resource.Error -> {

                    }
                }
            } catch (e: CancellationException) {
                e.printStackTrace()
            }
            finally {
                _isLoading.value = false
            }
        }
    }
}
