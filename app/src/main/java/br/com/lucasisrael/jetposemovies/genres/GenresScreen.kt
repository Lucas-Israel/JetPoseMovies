package br.com.lucasisrael.jetposemovies.genres

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.lucasisrael.jetposemovies.common.navigation.NavigationActions
import kotlinx.serialization.Serializable

@Serializable
object GenresScreen

@Composable
fun GenresScreen(navigationActions: NavigationActions) {

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background,
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = "Genres Screen",
                modifier = Modifier.padding(16.dp)
            )
            Button(onClick = {
                navigationActions.toMovieGenreScreen()
            }) {
                Text(text = "Go to Movies Genre Screen")
            }
        }
    }
}
