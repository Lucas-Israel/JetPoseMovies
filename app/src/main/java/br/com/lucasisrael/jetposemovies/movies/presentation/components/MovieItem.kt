package br.com.lucasisrael.jetposemovies.movies.presentation.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.lucasisrael.jetposemovies.common.presentation.components.CustomCard
import br.com.lucasisrael.jetposemovies.movies.domain.models.MovieDomain

@SuppressWarnings("FunctionNaming")
@Composable
fun MovieItem(
    movie: MovieDomain,
    modifier: Modifier
) {
    CustomCard(
        title = movie.title,
        url = movie.backdropPath,
        modifier = modifier
    )
}
