package br.com.lucasisrael.jetposemovies.genres.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import br.com.lucasisrael.jetposemovies.common.ui.components.SearchBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import br.com.lucasisrael.jetposemovies.R
import br.com.lucasisrael.jetposemovies.common.navigation.NavigationActions
import br.com.lucasisrael.jetposemovies.common.ui.components.CustomCard
import br.com.lucasisrael.jetposemovies.common.ui.screen.LoadingScreen
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

    val collectingGenres by viewModel.genres.collectAsStateWithLifecycle()
    val isLoading by viewModel.isLoading.collectAsStateWithLifecycle()

    if (isLoading) {
        LoadingScreen()
    } else {
        ScreenStructure {
            Text(
                text = stringResource(R.string.movie_genres),
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )

            SearchBar {
                viewModel.searchGenres(it)
            }

            LazyColumn(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                if (collectingGenres.isNotEmpty()) {
                    collectingGenres.forEach {
                        item {
                            CustomCard(
                                title = it.name,
                                url = it.imgUrl,
                                modifier = Modifier
                                    .clickable {
                                        navigationActions.toMovieGenreScreen(
                                            it.id.toString(),
                                            it.name
                                        )
                                    }
                            )
                        }
                    }
                }
            }
        }
    }
}
