package br.com.lucasisrael.jetposemovies.genres

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import br.com.lucasisrael.jetposemovies.common.navigation.NavigationActions
import kotlinx.serialization.Serializable

@Serializable
object GenresScreen

@Suppress("FunctionNaming")
@Composable
fun GenresScreen(
    navigationActions: NavigationActions,
    viewModel: GenresViewModel = hiltViewModel(),
) {
    val genres by viewModel.genres.collectAsStateWithLifecycle()

    viewModel.getFromRepository()

    Surface(
        modifier = Modifier.fillMaxSize().padding(32.dp),
        color = MaterialTheme.colorScheme.background,
    ) {
        LazyColumn(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            if (genres.genres.isNotEmpty()) {
                genres.genres.forEach {
                    item {
                        Text(
                            text = it.name,
                            modifier = Modifier.padding(16.dp)
                        )
                    }
                }
            }
            item {
                Button(onClick = {
                    navigationActions.toMovieGenreScreen()
                }) {
                    Text(text = "Go to Movies Genre Screen")
                }
            }
        }

    }
}
