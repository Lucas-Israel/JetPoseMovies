package br.com.lucasisrael.jetposemovies.common.presentation.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import br.com.lucasisrael.jetposemovies.common.navigation.NavigationActions
import br.com.lucasisrael.jetposemovies.genres.presentation.components.GenresComponent
import br.com.lucasisrael.jetposemovies.movies.presentation.components.NowPlayingMoviesComponent
import br.com.lucasisrael.jetposemovies.movies.presentation.components.PopularMoviesComponent
import br.com.lucasisrael.jetposemovies.movies.presentation.components.TopRatedMoviesComponent
import br.com.lucasisrael.jetposemovies.movies.presentation.components.UpcomingMoviesComponent
import kotlinx.serialization.Serializable

@Serializable
object InitialScreen

@SuppressWarnings("FunctionNaming")
@Composable
fun InitialScreen(
    navigationActions: NavigationActions,
) {
    ScreenStructure {
        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            item {
                UpcomingMoviesComponent(navigationActions = navigationActions)
            }
            item {
                GenresComponent(navigationActions = navigationActions)
            }
            item {
                PopularMoviesComponent(navigationActions = navigationActions)
            }
            item {
                TopRatedMoviesComponent(navigationActions = navigationActions)
            }
            item {
                NowPlayingMoviesComponent(navigationActions = navigationActions)
            }
        }
    }
}
