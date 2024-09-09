package br.com.lucasisrael.jetposemovies.genres

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import br.com.lucasisrael.jetposemovies.common.ui.components.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import br.com.lucasisrael.jetposemovies.common.navigation.NavigationActions
import br.com.lucasisrael.jetposemovies.common.ui.screen.ScreenStructure
import kotlinx.serialization.Serializable

@Serializable
object GenresScreen

@Suppress("FunctionNaming")
@Composable
fun GenresScreen(
    navigationActions: NavigationActions,
    viewModel: GenresViewModel = hiltViewModel(),
) {
    viewModel.getFromRepository()

    val collectingGenres by viewModel.genres.collectAsStateWithLifecycle()
    val genresList = collectingGenres.genres

    ScreenStructure {
        SearchBar(
            hint = "Search...",
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {

        }
        LazyColumn(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            if (genresList.isNotEmpty()) {
                genresList.forEach {
                    item {
                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier
                                .padding(10.dp)
                                .shadow(5.dp, RoundedCornerShape(10.dp))
                                .clip(RoundedCornerShape(10.dp))
                                .aspectRatio(1f)
                                .background(
                                    Brush.verticalGradient(
                                        listOf(
                                            Color(color = Color.Blue.toArgb()),
                                            Color(color = Color.Gray.toArgb())
                                        )
                                    )
                                )
                                .clickable {
                                    navigationActions.toMovieGenreScreen()
                                }
                        ) {
                            Text(
                                text = it.name,
                                modifier = Modifier.padding(16.dp),
                            )
                        }
                    }
                }
            }
        }
    }
}
