package br.com.lucasisrael.jetposemovies.movies.presentation.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.paging.compose.LazyPagingItems
import br.com.lucasisrael.jetposemovies.R
import br.com.lucasisrael.jetposemovies.common.navigation.NavigationActions
import br.com.lucasisrael.jetposemovies.movies.models.domain.MovieDomain

@SuppressWarnings("FunctionNaming")
@Composable
fun TopRatedMoviesComponent(
    navigationActions: NavigationActions,
    movies: LazyPagingItems<MovieDomain>
) {
    val categoryText = stringResource(R.string.top_rated_movies)

    CustomLazyRow(movies, navigationActions, categoryText)
}