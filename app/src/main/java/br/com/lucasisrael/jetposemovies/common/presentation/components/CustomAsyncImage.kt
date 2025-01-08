package br.com.lucasisrael.jetposemovies.common.presentation.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import br.com.lucasisrael.jetposemovies.R
import br.com.lucasisrael.jetposemovies.common.utils.constants.Constants.HALF_FLOAT
import coil.compose.AsyncImage

@SuppressWarnings("FunctionNaming")
@Composable
fun CustomAsyncImage(
    url: String?,
    title: String?,
    modifier: Modifier,
    enableGradient: Boolean = false
){
    val color = MaterialTheme.colorScheme.background
    val modified = if (enableGradient) {
        modifier
            .drawWithCache {
                onDrawWithContent {
                    drawContent()
                    drawRect(
                        Brush.verticalGradient(
                            HALF_FLOAT to color.copy(alpha = 0.25f),
                            2f to color
                        )
                    )
                }
            }
    } else {
        modifier
    }

    AsyncImage(
        model =  stringResource(R.string.image_base_url, url ?: "" ),
        contentDescription = stringResource(R.string.movie_image_from_the_genre, title ?: ""),
        placeholder = painterResource(id = R.drawable.ic_launcher_foreground),
        error = painterResource(id = R.drawable.ic_action_name),
        contentScale = ContentScale.FillWidth,
        modifier = modified
    )
}
