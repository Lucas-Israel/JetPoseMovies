@file:Suppress("FunctionNaming")

package br.com.lucasisrael.jetposemovies.movies.presentation.screen

import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import br.com.lucasisrael.jetposemovies.common.navigation.NavigationActions
import br.com.lucasisrael.jetposemovies.common.presentation.components.CustomCard
import br.com.lucasisrael.jetposemovies.common.presentation.screens.LoadingScreen
import br.com.lucasisrael.jetposemovies.common.presentation.screens.ScreenStructure
import br.com.lucasisrael.jetposemovies.movies.models.domain.MovieDomain
import br.com.lucasisrael.jetposemovies.movies.presentation.viewmodel.MovieListViewModel

import kotlinx.serialization.Serializable

@Serializable
data class MovieListFromGenreScreen(
    val genreId: Int,
    val genreName: String,
)

@Composable
fun MovieListFromGenreScreen(
    navigationActions: NavigationActions,
    viewModel: MovieListViewModel = hiltViewModel(),
    genreId: Int,
    genreName: String,
) {
    val rememberGenreId = remember { genreId }
    LaunchedEffect(key1 = rememberGenreId) { viewModel.setFlow(rememberGenreId) }
    val movies = viewModel.pagingFlow.collectAsLazyPagingItems()
    val isLoading = remember(key1 = movies.loadState.refresh) { movies.loadState.refresh == LoadState.Loading }

    ScreenStructure {
        if (isLoading) {
            LoadingScreen()
        } else {
            MoviesByGenreOrientation(
                genreName = genreName,
                movies = movies,
                navigationActions = navigationActions,
            )
        }
    }
}

@Composable
private fun MoviesByGenreOrientation(
    genreName: String,
    movies: LazyPagingItems<MovieDomain>,
    navigationActions: NavigationActions,
) {
    val orientation = LocalConfiguration.current.orientation
    val isLandScape = remember { orientation == Configuration.ORIENTATION_LANDSCAPE }
    val listState = rememberLazyListState()

    Text(
        text = genreName,
        fontStyle = FontStyle.Italic,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp
    )
    if (isLandScape) {
        MovieByGenreRow(
            movies = movies,
            navigationActions = navigationActions,
            listState = listState
        )
    } else {
        MovieByGenreColumn(
            movies = movies,
            navigationActions = navigationActions,
            listState = listState
        )
    }
}

@Composable
private fun MovieByGenreRow(
    movies: LazyPagingItems<MovieDomain>,
    navigationActions: NavigationActions,
    listState: LazyListState,
) {

    LazyRow(
        contentPadding = PaddingValues(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        state = listState
    ) {
        items(count = movies.itemCount) { index ->
            val movie = movies[index]
            if (movie != null) {
                CustomCard(
                    title = movie.title,
                    url = movie.posterPath,
                    modifier = Modifier
                        .fillMaxSize()
                        .clickable {
                            navigationActions.toDetailsScreen(movieId = movie.id!!)
                        }
                )
            }
        }
    }
}

@Composable
private fun MovieByGenreColumn(
    movies: LazyPagingItems<MovieDomain>,
    navigationActions: NavigationActions,
    listState: LazyListState,
) {

    LazyColumn(
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        state = listState,
        modifier = Modifier
            .fillMaxSize()
    ) {
        items(count = movies.itemCount) { index ->
            val movie = movies[index]
            if (movie != null) {
                CustomCard(
                    title = movie.title,
                    url = movie.posterPath,
                    modifier = Modifier
                        .fillMaxHeight()
                        .clickable {
                            navigationActions.toDetailsScreen(movieId = movie.id!!)
                        }
                )
            }
        }
    }
}
