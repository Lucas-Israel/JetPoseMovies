package br.com.lucasisrael.jetposemovies.movies.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import br.com.lucasisrael.jetposemovies.R
import br.com.lucasisrael.jetposemovies.common.navigation.NavigationActions
import br.com.lucasisrael.jetposemovies.common.utils.types.SearchType
import br.com.lucasisrael.jetposemovies.movies.presentation.viewmodel.MovieListViewModel

@SuppressWarnings("FunctionNaming")
@Composable
fun PopularMoviesComponent(
    navigationActions: NavigationActions,
    viewModel: MovieListViewModel = hiltViewModel(),
) {
    val page = 1

    viewModel.setMoviesFlow(searchType = SearchType.Popular(page = page))
    val movies = viewModel.popularMoviesPagingFlow.collectAsLazyPagingItems()

    ErrorViewer(movies = movies)

    Column(
        modifier = Modifier
            .padding(8.dp)
    ) {
        Text(
            text = stringResource(R.string.popular_movies),
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        )
            LazyRow {
                items(count = movies.itemCount) { index ->
                    val movie = movies[index]
                    if (movie != null) {
                        Box(
                            modifier = Modifier
                                .padding(4.dp)
                        ) {
                            if (movies.loadState.refresh is LoadState.Loading) {
                                CircularProgressIndicator(
                                    modifier = Modifier
                                )
                            } else {
                            MovieItem(
                                movie = movie,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clickable {
                                        navigationActions.toDetailsScreen(movieId = movie.id.toString())
                                    }
                            )
                        }
                    }
                }
            }
        }
    }
}
