package br.com.lucasisrael.jetposemovies.movies.presentation.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import br.com.lucasisrael.jetposemovies.common.navigation.NavigationActions
import br.com.lucasisrael.jetposemovies.common.presentation.components.Carousel
import br.com.lucasisrael.jetposemovies.common.presentation.screens.LoadingScreen
import br.com.lucasisrael.jetposemovies.movies.data.datasource.local.SearchType
import br.com.lucasisrael.jetposemovies.movies.presentation.viewmodel.MoviesListViewModel

@SuppressWarnings("FunctionNaming")
@Composable
fun UpcomingMoviesComponent(
    navigationActions: NavigationActions,
    viewModel: MoviesListViewModel = hiltViewModel(),
) {
    LaunchedEffect(Unit) {
        viewModel.getMoviesFromGenreRepository(searchType = SearchType.Upcoming)
    }

    val collectingMovies by viewModel.movieDomain.collectAsStateWithLifecycle()
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
