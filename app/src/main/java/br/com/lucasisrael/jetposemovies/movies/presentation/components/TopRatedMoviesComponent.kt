package br.com.lucasisrael.jetposemovies.movies.presentation.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import br.com.lucasisrael.jetposemovies.R
import br.com.lucasisrael.jetposemovies.common.navigation.NavigationActions
import br.com.lucasisrael.jetposemovies.common.utils.types.ApiQuery
import br.com.lucasisrael.jetposemovies.common.utils.types.SearchType
import br.com.lucasisrael.jetposemovies.movies.presentation.viewmodel.MovieListViewModel

@SuppressWarnings("FunctionNaming")
@Composable
fun TopRatedMoviesComponent(
    navigationActions: NavigationActions,
    viewModel: MovieListViewModel = hiltViewModel(),
) {
    val page = 1

    viewModel.setMoviesFlow(searchType = SearchType.TopRated(page = page))
    val movies = viewModel.topRatedMoviesPagingFlow.collectAsLazyPagingItems()

    val categoryText = stringResource(R.string.top_rated_movies)

    CustomLazyRow(movies, navigationActions, categoryText)
}