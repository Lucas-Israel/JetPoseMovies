package br.com.lucasisrael.jetposemovies.details.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.lucasisrael.jetposemovies.common.navigation.NavigationActions
import br.com.lucasisrael.jetposemovies.common.presentation.components.CustomButton
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
        horizontalArrangement = Arrangement.spacedBy(space = 8.dp),
        verticalArrangement = Arrangement.spacedBy(space = (-16).dp),
        modifier = Modifier
            .fillMaxSize()
    ) {
        genres?.map {
            CustomButton(
                onClick = {
                navigationActions.toMovieGenreScreen(
                    genreId = it.id,
                    genreName = it.name
                )},
                modifier = modifier
            ) {
                Text(text = it.name)
            }
        }
    }
}
