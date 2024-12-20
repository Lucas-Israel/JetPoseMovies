package br.com.lucasisrael.jetposemovies.movies.presentation.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import br.com.lucasisrael.jetposemovies.R
import br.com.lucasisrael.jetposemovies.common.navigation.NavigationActions
import br.com.lucasisrael.jetposemovies.movies.presentation.viewmodel.NowPlayingMoviesViewModel

@SuppressWarnings("FunctionNaming")
@Composable
fun NowPlayingMoviesComponent(
    navigationActions: NavigationActions,
    viewModel: NowPlayingMoviesViewModel = hiltViewModel(),
) {
    viewModel.setFlow()
    val movies = viewModel.pagingFlow.collectAsLazyPagingItems()

    val categoryText = stringResource(R.string.now_playing_movies)

    CustomLazyRow(movies, navigationActions, categoryText)
}