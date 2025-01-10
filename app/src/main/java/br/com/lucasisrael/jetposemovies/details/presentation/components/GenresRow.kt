package br.com.lucasisrael.jetposemovies.details.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import br.com.lucasisrael.jetposemovies.common.navigation.NavigationActions
import br.com.lucasisrael.jetposemovies.genres.models.domain.GenreDomain

@OptIn(ExperimentalLayoutApi::class)
@SuppressWarnings("FunctionNaming")
@Composable
fun GenresRow(
    genres: List<GenreDomain>?,
    modifier: Modifier,
    navigationActions: NavigationActions,
) {
    FlowRow(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        genres?.map {
            Box(
                modifier = Modifier
                    .padding(4.dp)
            ) {
                Text(
                    text = it.name,
                    modifier = modifier
                        .clip(RoundedCornerShape(6.dp))
                        .background(MaterialTheme.colorScheme.surfaceContainerHigh)
                        .padding(8.dp)
                        .clickable {
                            navigationActions.toMovieGenreScreen(
                                genreId = it.id,
                                genreName = it.name
                            )
                        }
                )
            }
        }
    }
}
