package br.com.lucasisrael.jetposemovies.moviesgenre.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.lucasisrael.jetposemovies.common.coroutines.CoroutinesProvider
import br.com.lucasisrael.jetposemovies.common.models.Movie
import br.com.lucasisrael.jetposemovies.common.models.Resource
import br.com.lucasisrael.jetposemovies.moviesgenre.data.mappers.toMoviesFromGenre
import br.com.lucasisrael.jetposemovies.moviesgenre.data.models.domain.MoviesFromGenre
import br.com.lucasisrael.jetposemovies.moviesgenre.data.repository.MoviesFromGenreRepository
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
) : ViewModel() {

    private val _isLoading = MutableStateFlow(true)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    private val _moviesFromGenre =
        MutableStateFlow(MoviesFromGenre(0, listOf(), 0, 0))
    val moviesFromGenre: StateFlow<MoviesFromGenre> = _moviesFromGenre.asStateFlow()

    private var cachedMoviesFromGenre =
        MoviesFromGenre(0, listOf<Movie>(), 0, 0)
    private var isSearchStarting = true

    fun searchMoviesFromGenre(query: String) {
        val listToSearch = if (isSearchStarting) {
            _moviesFromGenre.value
        } else {
            cachedMoviesFromGenre
        }
        viewModelScope.launch(coroutinesProvider.default()) {
            if (query.isEmpty()) {
                _moviesFromGenre.value = cachedMoviesFromGenre
                isSearchStarting = true
                return@launch
            }
            val results = listToSearch.results.filter {
                it.title.contains(query.trim(), ignoreCase = true)
            }

            val totalResult = MoviesFromGenre(
                _moviesFromGenre.value.page,
                results,
                _moviesFromGenre.value.total_pages,
                _moviesFromGenre.value.total_results
            )

            if (isSearchStarting) {
                cachedMoviesFromGenre = _moviesFromGenre.value
                isSearchStarting = false
            }
            _moviesFromGenre.value = totalResult
        }
    }

    fun getMoviesFromGenreRepository(genreId: String, page: Int) {
        viewModelScope.launch(coroutinesProvider.io()) {
            try {
                _isLoading.value = true
                when (val response = repository.getMoviesFromGenre(genreId, page)) {
                    is Resource.Success -> {
                        _moviesFromGenre.value = response.data!!.toMoviesFromGenre()
                    }

                    is Resource.Error -> {

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
