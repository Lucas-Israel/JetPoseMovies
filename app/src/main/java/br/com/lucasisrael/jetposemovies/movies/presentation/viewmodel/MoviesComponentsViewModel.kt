package br.com.lucasisrael.jetposemovies.movies.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import br.com.lucasisrael.jetposemovies.movies.data.repository.NowPlayingMoviesRepository
import br.com.lucasisrael.jetposemovies.movies.data.repository.PopularMoviesRepository
import br.com.lucasisrael.jetposemovies.movies.data.repository.TopRatedMoviesRepository
import br.com.lucasisrael.jetposemovies.movies.data.repository.UpcomingMoviesRepository
import br.com.lucasisrael.jetposemovies.movies.models.domain.MovieDomain
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class MoviesComponentsViewModel @Inject constructor(
    nowPlayingMoviesRepository: NowPlayingMoviesRepository,
    popularMoviesRepository: PopularMoviesRepository,
    topRatedMoviesRepository: TopRatedMoviesRepository,
    upcomingMoviesRepository: UpcomingMoviesRepository,
) : ViewModel() {

    var nowPlayingMoviesPagingFlow: Flow<PagingData<MovieDomain>> =
        nowPlayingMoviesRepository.flow().cachedIn(viewModelScope)

    var popularMoviesPagingFlow: Flow<PagingData<MovieDomain>> =
        popularMoviesRepository.flow().cachedIn(viewModelScope)

    var topRatedMoviesPagingFlow: Flow<PagingData<MovieDomain>> =
        topRatedMoviesRepository.flow().cachedIn(viewModelScope)

    var upcomingMoviesPagingFlow: Flow<PagingData<MovieDomain>> =
        upcomingMoviesRepository.flow().cachedIn(viewModelScope)
}
