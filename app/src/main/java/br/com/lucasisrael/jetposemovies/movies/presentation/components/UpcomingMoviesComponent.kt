package br.com.lucasisrael.jetposemovies.movies.presentation.components

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import br.com.lucasisrael.jetposemovies.common.navigation.NavigationActions
import br.com.lucasisrael.jetposemovies.common.presentation.components.Carousel
import br.com.lucasisrael.jetposemovies.common.utils.types.SearchType
import br.com.lucasisrael.jetposemovies.movies.presentation.viewmodel.MovieListViewModel

@SuppressWarnings("FunctionNaming")
@Composable
fun UpcomingMoviesComponent(
    navigationActions: NavigationActions,
    viewModel: MovieListViewModel = hiltViewModel(),
) {

    val page = 1

    viewModel.setMoviesFlow(searchType = SearchType.Upcoming(page = page))
    val movies = viewModel.upcomingMoviesPagingFlow.collectAsLazyPagingItems()

    Carousel(
        items = movies,
        navigationActions = navigationActions
    )
}
