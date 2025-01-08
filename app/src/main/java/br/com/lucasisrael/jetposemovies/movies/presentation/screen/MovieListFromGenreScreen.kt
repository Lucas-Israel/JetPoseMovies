package br.com.lucasisrael.jetposemovies.movies.presentation.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import br.com.lucasisrael.jetposemovies.common.navigation.NavigationActions
import br.com.lucasisrael.jetposemovies.common.presentation.components.CustomCard
import br.com.lucasisrael.jetposemovies.common.presentation.screens.LoadingScreen
import br.com.lucasisrael.jetposemovies.common.presentation.screens.ScreenStructure
import br.com.lucasisrael.jetposemovies.movies.presentation.viewmodel.MovieListViewModel
import kotlinx.serialization.Serializable

@Serializable
data class MovieListFromGenreScreen(
    val genreId: Int,
    val genreName: String,
)

@Suppress("FunctionNaming")
@Composable
fun MovieListFromGenreScreen(
    navigationActions: NavigationActions,
    viewModel: MovieListViewModel = hiltViewModel(),
    genreId: Int,
    genreName: String,
) {
    val rememberGenreId = remember {
        genreId
    }

    LaunchedEffect(rememberGenreId) {
        viewModel.setFlow(rememberGenreId)
    }

    val movies = viewModel.pagingFlow.collectAsLazyPagingItems()

    if (movies.loadState.refresh is LoadState.Loading) {
        LoadingScreen()
    } else {
        ScreenStructure {
            Text(
                text = "$genreName movies",
                fontWeight = FontWeight.Bold,
                fontSize = 25.sp,
                fontStyle = FontStyle.Italic
            )
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                items(count = movies.itemCount) { index ->
                    val movie = movies[index]
                    if (movie != null) {
                        CustomCard(
                            title = movie.title,
                            url = movie.posterPath,
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable {
                                    movie.id?.let { navigationActions.toDetailsScreen(movieId = it) }
                                }
                        )
                    }
                }
            }
        }
    }
}
