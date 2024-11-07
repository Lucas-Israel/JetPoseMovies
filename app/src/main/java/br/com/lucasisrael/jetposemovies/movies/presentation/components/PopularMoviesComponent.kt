package br.com.lucasisrael.jetposemovies.movies.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import br.com.lucasisrael.jetposemovies.R
import br.com.lucasisrael.jetposemovies.common.navigation.NavigationActions
import br.com.lucasisrael.jetposemovies.common.presentation.components.CustomCard
import br.com.lucasisrael.jetposemovies.common.presentation.screens.LoadingScreen
import br.com.lucasisrael.jetposemovies.movies.presentation.viewmodel.MovieListViewModel
import coil.compose.AsyncImage

@SuppressWarnings("FunctionNaming")
@Composable
fun PopularMoviesComponent(
    navigationActions: NavigationActions,
    viewModel: MovieListViewModel = hiltViewModel(),
) {
    var page = 1

    LaunchedEffect(Unit) {
        viewModel.getPopularMovies(page = page)
    }

    val collectingMovies by viewModel.popularMovies.collectAsStateWithLifecycle()
    val isLoading by viewModel.isLoading.collectAsStateWithLifecycle()

    if (isLoading) {
        LoadingScreen()
    } else {
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
                item {
                    collectingMovies.map {
                        Box(
                            modifier = Modifier
                                .padding(4.dp)
                                .clickable {
                                    navigationActions.toDetailsScreen(it.id.toString())
                                }
                        ) {
                            AsyncImage(
                                model = stringResource(
                                    R.string.image_base_url,
                                    it.backdropPath ?: ""
                                ),
                                contentDescription = stringResource(
                                    R.string.movie_image_from_the_genre,
                                    it.title ?: ""
                                ),
                                placeholder = painterResource(id = R.drawable.ic_launcher_foreground),
                                error = painterResource(id = R.drawable.ic_action_name),
                                contentScale = ContentScale.FillWidth,
                                modifier = Modifier
                                    .fillMaxSize()
                            )
                        }
                    }
                }
            }
        }
    }
}
