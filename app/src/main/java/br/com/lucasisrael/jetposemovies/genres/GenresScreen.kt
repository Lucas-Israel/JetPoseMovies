package br.com.lucasisrael.jetposemovies.genres

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import br.com.lucasisrael.jetposemovies.common.ui.components.SearchBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import br.com.lucasisrael.jetposemovies.common.navigation.NavigationActions
import br.com.lucasisrael.jetposemovies.common.ui.components.CustomCard
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

    ScreenStructure {
        SearchBar(
            hint = "Search..."
        ) {
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
                            url = it.imgUrl!!,
                            modifier = Modifier
                                .clickable {
                                    navigationActions.toMovieGenreScreen()
                                }
                        )
                    }
                }
            }
        }
    }
}
