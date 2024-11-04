package br.com.lucasisrael.jetposemovies.movies.presentation.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import br.com.lucasisrael.jetposemovies.R
import br.com.lucasisrael.jetposemovies.common.navigation.NavigationActions
import br.com.lucasisrael.jetposemovies.common.presentation.components.CustomCard
import br.com.lucasisrael.jetposemovies.common.presentation.components.SearchBar
import br.com.lucasisrael.jetposemovies.common.presentation.screens.LoadingScreen
import br.com.lucasisrael.jetposemovies.common.presentation.screens.ScreenStructure
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
    genreName: String
) {
    LaunchedEffect(Unit) {
        viewModel.getMoviesFromGenreRepository(genreId)
    }

    val collectingMovies by viewModel.moviesFromGenre.collectAsStateWithLifecycle()
    val isLoading by viewModel.isLoading.collectAsStateWithLifecycle()

    if (isLoading) {
        LoadingScreen()
    } else {
        ScreenStructure {
            Text(
                text = stringResource(R.string.movies, genreName),
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )

            SearchBar {
                viewModel.searchMoviesFromGenre(it)
            }

            LazyColumn(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                if (collectingMovies.isNotEmpty()) {
                    collectingMovies.forEach {
                        item {
                            CustomCard(
                                title = it.title,
                                url = it.posterPath,
                                rating = it.voteAverage,
                                modifier = Modifier
                                    .clickable {
                                        navigationActions.toDetailsScreen(it.id.toString())
                                    }
                            )
                        }
                    }
                }
            }
        }
    }
}
