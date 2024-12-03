package br.com.lucasisrael.jetposemovies.common.presentation.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import br.com.lucasisrael.jetposemovies.R
import coil.compose.AsyncImage

@SuppressWarnings("FunctionNaming")
@Composable
fun CustomAsyncImage(
    url: String?,
    title: String?,
    modifier: Modifier,
){
    AsyncImage(
        model =  stringResource(R.string.image_base_url, url ?: "" ),
        contentDescription = stringResource(R.string.movie_image_from_the_genre, title ?: ""),
        placeholder = painterResource(id = R.drawable.ic_launcher_foreground),
        error = painterResource(id = R.drawable.ic_action_name),
        contentScale = ContentScale.FillWidth,
        modifier = modifier
            .fillMaxSize()
    )
}
