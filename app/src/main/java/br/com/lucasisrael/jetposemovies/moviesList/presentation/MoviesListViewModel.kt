package br.com.lucasisrael.jetposemovies.moviesList.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.lucasisrael.jetposemovies.common.coroutines.CoroutinesProvider
import br.com.lucasisrael.jetposemovies.common.models.Movie
import br.com.lucasisrael.jetposemovies.moviesList.domain.models.MoviesList
import br.com.lucasisrael.jetposemovies.moviesList.domain.usecase.MoviesListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoviesListViewModel @Inject constructor(
    private val moviesFromGenreUseCase: MoviesListUseCase,
    private val coroutinesProvider: CoroutinesProvider
) : ViewModel() {

    private val _isLoading = MutableStateFlow(true)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    private val _moviesList =
        MutableStateFlow(MoviesList(0, listOf(), 0, 0))
    val moviesList: StateFlow<MoviesList> = _moviesList.asStateFlow()

    private var cachedMoviesList =
        MoviesList(0, listOf<Movie>(), 0, 0)
    private var isSearchStarting = true

    fun searchMoviesFromGenre(query: String) {
        val listToSearch = if (isSearchStarting) {
            _moviesList.value
        } else {
            cachedMoviesList
        }
        viewModelScope.launch(coroutinesProvider.default()) {
            if (query.isEmpty()) {
                _moviesList.value = cachedMoviesList
                isSearchStarting = true
                return@launch
            }
            val results = listToSearch.results.filter {
                it.title.contains(query.trim(), ignoreCase = true)
            }

            val totalResult = MoviesList(
                _moviesList.value.page,
                results,
                _moviesList.value.totalPages,
                _moviesList.value.totalResults
            )

            if (isSearchStarting) {
                cachedMoviesList = _moviesList.value
                isSearchStarting = false
            }
            _moviesList.value = totalResult
        }
    }

    fun getMoviesFromGenreRepository(genreId: String, page: Int) {
        viewModelScope.launch(coroutinesProvider.io()) {
            try {
                _isLoading.value = true
                _moviesList.value = moviesFromGenreUseCase.getMoviesFromGenre(genreId, page)
            } catch (e: CancellationException) {
                e.printStackTrace()
            } finally {
                _isLoading.value = false
            }
        }
    }
}
