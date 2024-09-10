package br.com.lucasisrael.jetposemovies.genres

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import br.com.lucasisrael.jetposemovies.common.ui.components.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import br.com.lucasisrael.jetposemovies.common.navigation.NavigationActions
import br.com.lucasisrael.jetposemovies.common.ui.screen.ScreenStructure
import coil.compose.AsyncImage
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
            if (collectingGenres.isNotEmpty()) {
                collectingGenres.forEach {
                    item {
                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier
                                .fillMaxSize()
                                .clickable {
                                    navigationActions.toMovieGenreScreen()
                                }
                                .padding(8.dp)
                        ) {

                            Card(
                                modifier = Modifier
                                    .fillMaxWidth(),
                                elevation = CardDefaults.cardElevation(10.dp),
                                colors = CardDefaults.cardColors(
                                    containerColor = Color.DarkGray
                                )
                            ) {
                                Column(
                                    modifier = Modifier.fillMaxSize()
                                ) {
                                    AsyncImage(
                                        model = "https://image.tmdb.org/t/p/w500${it.imgUrl}",
                                        contentDescription = "image of a movie from the ${it.name} genre",
                                        contentScale = ContentScale.FillBounds,
                                        modifier = Modifier.height(400.dp)
                                    )
                                    Text(
                                        text = it.name,
                                        modifier = Modifier.padding(10.dp),
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 24.sp,
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
