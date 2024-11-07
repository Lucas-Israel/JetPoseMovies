package br.com.lucasisrael.jetposemovies.movies.presentation.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import br.com.lucasisrael.jetposemovies.common.navigation.NavigationActions
import br.com.lucasisrael.jetposemovies.common.presentation.components.Carousel
import br.com.lucasisrael.jetposemovies.common.presentation.screens.LoadingScreen
import br.com.lucasisrael.jetposemovies.movies.presentation.viewmodel.MovieListViewModel

@SuppressWarnings("FunctionNaming")
@Composable
fun UpcomingMoviesComponent(
    navigationActions: NavigationActions,
    viewModel: MovieListViewModel = hiltViewModel(),
) {

    var page: Int = 1

    LaunchedEffect(Unit) {
        viewModel.getUpcomingMovies(page = page)
    }

    val collectingMovies by viewModel.upcomingMovies.collectAsStateWithLifecycle()
    val isLoading by viewModel.isLoading.collectAsStateWithLifecycle()

    if (isLoading) {
        LoadingScreen()
    } else {
        Carousel(
            items = collectingMovies,
            navigationActions = navigationActions
        )
    }
}
