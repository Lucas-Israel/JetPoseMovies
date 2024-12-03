package br.com.lucasisrael.jetposemovies.movies.presentation.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import br.com.lucasisrael.jetposemovies.common.navigation.NavigationActions
import br.com.lucasisrael.jetposemovies.common.presentation.screens.ScreenStructure
import br.com.lucasisrael.jetposemovies.common.utils.types.SearchType
import br.com.lucasisrael.jetposemovies.movies.presentation.components.ErrorViewer
import br.com.lucasisrael.jetposemovies.movies.presentation.components.MovieItem
import br.com.lucasisrael.jetposemovies.movies.presentation.viewmodel.MovieListViewModel
import kotlinx.serialization.Serializable

@Serializable
data class MovieListFromGenreScreen(
    val genreId: String,
    val genreName: String,
)

@Suppress("FunctionNaming")
@Composable
fun MovieListFromGenreScreen(
    navigationActions: NavigationActions,
    viewModel: MovieListViewModel = hiltViewModel(),
    genreId: String,
    genreName: String,
) {
    viewModel.setMoviesFlow(searchType = SearchType.GenreId(genreId = genreId, page = 1))
    val movies = viewModel.moviesByGenrePagingFlow.collectAsLazyPagingItems()

    ErrorViewer(movies = movies)

    ScreenStructure {
        Text(text= "$genreName movies")
        Box(modifier = Modifier.fillMaxSize()) {
            if (movies.loadState.refresh is LoadState.Loading) {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center)
                )
            } else {
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    items(count = movies.itemCount) { index ->
                        val movie = movies[index]
                        if (movie != null) {
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
