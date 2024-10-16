package br.com.lucasisrael.jetposemovies.details.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import br.com.lucasisrael.jetposemovies.common.navigation.NavigationActions
import br.com.lucasisrael.jetposemovies.common.ui.components.CustomCard
import br.com.lucasisrael.jetposemovies.common.ui.screen.LoadingScreen
import br.com.lucasisrael.jetposemovies.common.ui.screen.ScreenStructure
import kotlinx.serialization.Serializable

@Serializable
data class DetailsScreen(
    val movieId: String
)

@Suppress("FunctionNaming")
@Composable
fun DetailsScreen(
    navigationActions: NavigationActions,
    viewModel: DetailsViewModel = hiltViewModel(),
    movieId: String
) {
    LaunchedEffect(Unit) {
        viewModel.getFromRepository(movieId)
    }

    val collectingDetails by viewModel.details.collectAsStateWithLifecycle()
    val isLoading by viewModel.isLoading.collectAsStateWithLifecycle()


    if (isLoading) {
        LoadingScreen()
    } else {
        ScreenStructure {
            collectingDetails?.let {
                CustomCard(
                    title = it.title,
                    url = it.posterPath,
                    modifier = Modifier
                )
            }

        }
    }
}
