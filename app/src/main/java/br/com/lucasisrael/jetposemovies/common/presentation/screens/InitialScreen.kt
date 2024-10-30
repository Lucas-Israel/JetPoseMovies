package br.com.lucasisrael.jetposemovies.common.presentation.screens

import androidx.compose.runtime.Composable
import br.com.lucasisrael.jetposemovies.common.navigation.NavigationActions
import br.com.lucasisrael.jetposemovies.genres.presentation.GenresComponent
import kotlinx.serialization.Serializable

@Serializable
object InitialScreen

@SuppressWarnings("FunctionNaming")
@Composable
fun InitialScreen(
    navigationActions: NavigationActions,
) {
    ScreenStructure {
        GenresComponent(navigationActions)
    }
}
