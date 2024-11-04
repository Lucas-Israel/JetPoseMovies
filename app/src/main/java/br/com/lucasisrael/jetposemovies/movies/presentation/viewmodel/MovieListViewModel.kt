package br.com.lucasisrael.jetposemovies.movies.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.lucasisrael.jetposemovies.common.coroutines.CoroutinesProvider
import br.com.lucasisrael.jetposemovies.movies.data.datasource.local.SearchType
import br.com.lucasisrael.jetposemovies.movies.domain.models.MovieDomain
import br.com.lucasisrael.jetposemovies.movies.domain.usecase.MoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieListViewModel @Inject constructor(
    private val movieUseCase: MoviesUseCase,
    private val coroutinesProvider: CoroutinesProvider
) : ViewModel() {

    private val _isLoading = MutableStateFlow(true)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    private val _moviesFromGenre =
        MutableStateFlow<List<MovieDomain>>(emptyList())
    val moviesFromGenre: StateFlow<List<MovieDomain>> = _moviesFromGenre.asStateFlow()

    private val _upcomingMovies = MutableStateFlow<List<MovieDomain>>(emptyList())
    val upcomingMovies: StateFlow<List<MovieDomain>> = _upcomingMovies.asStateFlow()

    private var cachedMovieDomain =
        emptyList<MovieDomain>()
    private var isSearchStarting = true


    fun searchMoviesFromGenre(query: String) {
        val listToSearch = if (isSearchStarting) {
            _moviesFromGenre.value
        } else {
            cachedMovieDomain
        }
        viewModelScope.launch(coroutinesProvider.default()) {
            if (query.isEmpty()) {
                _moviesFromGenre.value = cachedMovieDomain
                isSearchStarting = true
                return@launch
            }
            val results = listToSearch.filter {
                if (it.title == null) return@filter false
                it.title.contains(query.trim(), ignoreCase = true)
            }

            if (isSearchStarting) {
                cachedMovieDomain = _moviesFromGenre.value
                isSearchStarting = false
            }
            _moviesFromGenre.value = results
        }
    }

    fun getMoviesFromGenreRepository(genreId: String) {
        viewModelScope.launch(coroutinesProvider.io()) {
            try {
                _isLoading.value = true
                _moviesFromGenre.value = movieUseCase
                    .synchronizeMovies(searchType = SearchType.GenreId(genreId = genreId))

            } catch (e: CancellationException) {
                e.printStackTrace()
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun getUpcomingMovies() {
        viewModelScope.launch(coroutinesProvider.io()) {
            try {
                _isLoading.value = true
                _upcomingMovies.value =
                    movieUseCase.synchronizeMovies(searchType = SearchType.Upcoming)

            } catch (e: CancellationException) {
                e.printStackTrace()
            } finally {
                _isLoading.value = false
            }
        }
    }
}
