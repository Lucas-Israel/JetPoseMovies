package br.com.lucasisrael.jetposemovies.genres.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import br.com.lucasisrael.jetposemovies.common.navigation.NavigationActions
import br.com.lucasisrael.jetposemovies.genres.presentation.viewmodel.GenresViewModel
import kotlinx.serialization.Serializable

@Serializable
object GenresComponent

@Suppress("FunctionNaming")
@Composable
fun GenresComponent(
    navigationActions: NavigationActions,
    viewModel: GenresViewModel = hiltViewModel(),
) {

    val data = viewModel.pagingFlow.collectAsLazyPagingItems()

    LazyRow(
        modifier = Modifier
            .padding(8.dp)
    ) {
        items(count = data.itemCount) { index ->
            val genre = data[index]
            if (genre != null) {
                Box(
                    modifier = Modifier
                        .padding(4.dp)
                        .clickable {
                            navigationActions.toMovieGenreScreen(
                                genre.id,
                                genre.name
                            )
                        }
                ) {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .clip(RoundedCornerShape(6.dp))
                            .background(MaterialTheme.colorScheme.surfaceContainerHigh)
                            .padding(12.dp)
                            .width(150.dp)
                    ) {
                        Text(
                            text = genre.name,
                            modifier = Modifier
                        )

                    }

                }
            }
        }
    }
}
