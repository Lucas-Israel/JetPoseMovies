package br.com.lucasisrael.jetposemovies.movies.presentation.components

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import br.com.lucasisrael.jetposemovies.common.navigation.NavigationActions
import br.com.lucasisrael.jetposemovies.movies.presentation.viewmodel.UpcomingMoviesViewModel

@SuppressWarnings("FunctionNaming")
@Composable
fun UpcomingMoviesComponent(
    navigationActions: NavigationActions,
    viewModel: UpcomingMoviesViewModel = hiltViewModel(),
) {

    val movies = viewModel.pagingFlow.collectAsLazyPagingItems()

    Carousel(
        items = movies,
        navigationActions = navigationActions
    )
}
