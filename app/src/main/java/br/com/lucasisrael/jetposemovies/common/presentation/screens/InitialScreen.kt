@file:SuppressWarnings("FunctionNaming")

package br.com.lucasisrael.jetposemovies.common.presentation.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import br.com.lucasisrael.jetposemovies.common.navigation.NavigationActions
import br.com.lucasisrael.jetposemovies.genres.presentation.components.GenresComponent
import br.com.lucasisrael.jetposemovies.genres.presentation.viewmodel.GenresViewModel
import br.com.lucasisrael.jetposemovies.movies.presentation.components.NowPlayingMoviesComponent
import br.com.lucasisrael.jetposemovies.movies.presentation.components.PopularMoviesComponent
import br.com.lucasisrael.jetposemovies.movies.presentation.components.TopRatedMoviesComponent
import br.com.lucasisrael.jetposemovies.movies.presentation.components.UpcomingMoviesComponent
import br.com.lucasisrael.jetposemovies.movies.presentation.viewmodel.MoviesComponentsViewModel
import kotlinx.serialization.Serializable

@Serializable
object InitialScreen

@Composable
fun InitialScreen(
    navigationActions: NavigationActions,
    genresVM: GenresViewModel = hiltViewModel(),
    moviesVm: MoviesComponentsViewModel = hiltViewModel(),
) {
    val genres = genresVM.pagingFlow.collectAsLazyPagingItems()
    val upcoming = moviesVm.upcomingMoviesPagingFlow.collectAsLazyPagingItems()
    val popular = moviesVm.popularMoviesPagingFlow.collectAsLazyPagingItems()
    val topRated = moviesVm.topRatedMoviesPagingFlow.collectAsLazyPagingItems()
    val nowPlaying = moviesVm.nowPlayingMoviesPagingFlow.collectAsLazyPagingItems()
    val lazyPagingList = listOf(genres,upcoming,popular,topRated,nowPlaying)

    val isLoading = remember(lazyPagingList.map { it.loadState.refresh }) {
        lazyPagingList.any { it.loadState.refresh == LoadState.Loading }
    }

    ScreenStructure {
        if (isLoading) {
            LoadingScreen()
        } else {
            LazyColumn(
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                item {
                    UpcomingMoviesComponent(
                        navigationActions = navigationActions,
                        movies = upcoming
                    )
                }
                item {
                    GenresComponent(
                        navigationActions = navigationActions,
                        genres = genres
                    )
                }
                item {
                    PopularMoviesComponent(
                        navigationActions = navigationActions,
                        movies = popular
                    )
                }
                item {
                    TopRatedMoviesComponent(
                        navigationActions = navigationActions,
                        movies = topRated
                    )
                }
                item {
                    NowPlayingMoviesComponent(
                        navigationActions = navigationActions,
                        movies = nowPlaying
                    )
                }
            }
        }
    }
}
