package br.com.lucasisrael.jetposemovies.moviesgenre

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
object MoviesGenreScreen

@Composable
fun MoviesGenreScreen(navigationActions: NavigationActions) {

    // TODO movies genre screen
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background,
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            ) {
            Text(
                text = "Movies Genre Screen",
                modifier = Modifier.padding(16.dp)
            )
            Button(onClick = {
                navigationActions.toDetailsScreen()
            }) {
                Text(text = "Go to Details Screen")
            }
        }
    }
}
