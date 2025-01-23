package br.com.lucasisrael.jetposemovies.genres.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.compose.LazyPagingItems
import br.com.lucasisrael.jetposemovies.common.navigation.NavigationActions
import br.com.lucasisrael.jetposemovies.common.presentation.components.CustomButton
import br.com.lucasisrael.jetposemovies.genres.models.domain.GenreDomain

@Suppress("FunctionNaming")
@Composable
fun GenresComponent(
    navigationActions: NavigationActions,
    genres: LazyPagingItems<GenreDomain>,
) {

    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier
            .padding(8.dp)
    ) {
        items(count = genres.itemCount) { index ->
            val genre = genres[index]
            if (genre != null) {
                CustomButton(
                    onClick = {
                    navigationActions.toMovieGenreScreen(
                        genreId = genre.id,
                        genreName = genre.name
                    )},
                    modifier = Modifier
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
