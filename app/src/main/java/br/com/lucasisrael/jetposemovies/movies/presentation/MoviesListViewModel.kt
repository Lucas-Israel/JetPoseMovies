package br.com.lucasisrael.jetposemovies.movies.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.lucasisrael.jetposemovies.common.coroutines.CoroutinesProvider
import br.com.lucasisrael.jetposemovies.movies.domain.models.MovieDomain
import br.com.lucasisrael.jetposemovies.movies.domain.usecase.MoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

val EMPTY_MOVIE_DOMAIN = MovieDomain(
    backdropPath = "",
    releaseDate = "",
    adult = false,
    genreIds = listOf(),
    posterPath = "",
    originalTitle = "",
    popularity = 0.00,
    voteAverage = 0.00,
    title = "",
    voteCount = 0,
    video = false,
    overview = "",
    id = 0,
    originalLanguage = "",
)

@HiltViewModel
class MoviesListViewModel @Inject constructor(
    private val moviesFromGenreUseCase: MoviesUseCase,
    private val coroutinesProvider: CoroutinesProvider
) : ViewModel() {

    private val _isLoading = MutableStateFlow(true)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    private val _movieDomain =
        MutableStateFlow(listOf(EMPTY_MOVIE_DOMAIN))
    val movieDomain: StateFlow<List<MovieDomain>> = _movieDomain.asStateFlow()

    private var cachedMovieDomain =
        listOf(EMPTY_MOVIE_DOMAIN)
    private var isSearchStarting = true

    fun searchMoviesFromGenre(query: String) {
        val listToSearch = if (isSearchStarting) {
            _movieDomain.value
        } else {
            cachedMovieDomain
        }
        viewModelScope.launch(coroutinesProvider.default()) {
            if (query.isEmpty()) {
                _movieDomain.value = cachedMovieDomain
                isSearchStarting = true
                return@launch
            }
            val results = listToSearch.filter {
                it.title.contains(query.trim(), ignoreCase = true)
            }

            val totalResult = results.map {
                MovieDomain(
                    backdropPath = it.backdropPath,
                    genreIds = it.genreIds,
                    id = it.id,
                    posterPath = it.posterPath,
                    title = it.title,
                    originalTitle = it.title,
                    video = it.video,
                    overview = it.overview,
                    voteCount = it.voteCount,
                    releaseDate = it.releaseDate,
                    voteAverage = it.voteAverage,
                    adult = it.adult,
                    popularity = it.popularity,
                    originalLanguage = it.originalLanguage,
                )
            }

            if (isSearchStarting) {
                cachedMovieDomain = _movieDomain.value
                isSearchStarting = false
            }
            _movieDomain.value = totalResult
        }
    }

    fun getMoviesFromGenreRepository(genreId: String, page: Int) {
        viewModelScope.launch(coroutinesProvider.io()) {
            try {
                _isLoading.value = true
                _movieDomain.value = moviesFromGenreUseCase.getMoviesFromGenre(genreId, page)
            } catch (e: CancellationException) {
                e.printStackTrace()
            } finally {
                _isLoading.value = false
            }
        }
    }
}
