package br.com.lucasisrael.jetposemovies.common.presentation.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import br.com.lucasisrael.jetposemovies.common.navigation.NavigationActions
import br.com.lucasisrael.jetposemovies.genres.presentation.components.GenresComponent
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
        LazyColumn {
            item {
                UpcomingMoviesComponent(navigationActions)
            }
            item {
                GenresComponent(navigationActions)
            }
        }
    }
}
