package br.com.lucasisrael.jetposemovies.movies.presentation.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import br.com.lucasisrael.jetposemovies.R
import br.com.lucasisrael.jetposemovies.common.navigation.NavigationActions
import br.com.lucasisrael.jetposemovies.movies.presentation.viewmodel.PopularMoviesViewModel

@SuppressWarnings("FunctionNaming")
@Composable
fun PopularMoviesComponent(
    navigationActions: NavigationActions,
    viewModel: PopularMoviesViewModel = hiltViewModel(),
) {

    viewModel.setFlow()
    val movies = viewModel.pagingFlow.collectAsLazyPagingItems()

    val categoryText = stringResource(R.string.popular_movies)

    CustomLazyRow(movies, navigationActions, categoryText)
}
