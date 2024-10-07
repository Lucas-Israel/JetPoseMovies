package br.com.lucasisrael.jetposemovies.moviesgenre

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import br.com.lucasisrael.jetposemovies.common.navigation.NavigationActions
import br.com.lucasisrael.jetposemovies.common.ui.components.CustomCard
import br.com.lucasisrael.jetposemovies.common.ui.screen.LoadingScreen
import br.com.lucasisrael.jetposemovies.common.ui.screen.ScreenStructure
import kotlinx.serialization.Serializable

@Serializable
data class MoviesGenreScreen(
    val genreId: String
)

@Suppress("FunctionNaming")
@Composable
fun MoviesGenreScreen(
    navigationActions: NavigationActions,
    viewModel: MoviesFromGenreViewModel = hiltViewModel(),
    genreId: String
) {
    viewModel.getMoviesFromGenreRepository(genreId)
    val collectingMoviesGenre by viewModel.moviesFromGenre.collectAsStateWithLifecycle()
    val isLoading by viewModel.isLoading.collectAsStateWithLifecycle()

    if (isLoading) {
        LoadingScreen()
    } else {
        ScreenStructure {
            LazyColumn(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                val results = collectingMoviesGenre.results
                if (results.isNotEmpty()) {
                    results.forEach {
                        item {
                            CustomCard(
                                title = it.title,
                                url = it.poster_path,
                                modifier = Modifier
                                    .clickable {
                                        navigationActions.toDetailsScreen()
                                    }
                            )
                        }
                    }
                }
            }
        }
    }
}
