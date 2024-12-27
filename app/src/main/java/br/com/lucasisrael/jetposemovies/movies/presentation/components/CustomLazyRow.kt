package br.com.lucasisrael.jetposemovies.movies.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import br.com.lucasisrael.jetposemovies.common.navigation.NavigationActions
import br.com.lucasisrael.jetposemovies.common.presentation.components.ErrorViewer
import br.com.lucasisrael.jetposemovies.movies.models.domain.MovieDomain

@SuppressWarnings("FunctionNaming")
@Composable
fun CustomLazyRow(
    movies: LazyPagingItems<MovieDomain>,
    navigationActions: NavigationActions,
    categoryText: String
) {
    val listState = rememberLazyListState()

    ErrorViewer(movies = movies)

    Column(
        modifier = Modifier
            .padding(8.dp)
    ) {
        Text(
            text = categoryText,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        )
        LazyRow(state = listState) {
            items(count = movies.itemCount) { index ->
                Box(
                    modifier = Modifier
                        .width(200.dp)
                        .padding(4.dp)
                ) {
                    val movie = movies[index]
                    if (movie != null) {
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
                    } else {
                        CircularProgressIndicator(modifier = Modifier)
                    }
                }
            }
        }
    }
}