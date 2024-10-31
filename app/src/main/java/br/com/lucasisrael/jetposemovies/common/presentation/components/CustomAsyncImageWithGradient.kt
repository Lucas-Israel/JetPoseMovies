package br.com.lucasisrael.jetposemovies.common.presentation.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import br.com.lucasisrael.jetposemovies.R
import coil.compose.AsyncImage

const val HALF_FLOAT = 0.5f

@SuppressWarnings("FunctionNaming")
@Composable
fun CustomAsyncImageWithGradient(
    url: String?,
    title: String?,
    modifier: Modifier,
    color: Color
){
    AsyncImage(
        model =  stringResource(R.string.image_base_url, url ?: "" ),
        contentDescription = stringResource(R.string.movie_image_from_the_genre, title ?: ""),
        placeholder = painterResource(id = R.drawable.ic_launcher_foreground),
        error = painterResource(id = R.drawable.ic_action_name),
        contentScale = ContentScale.FillWidth,
        modifier = modifier
            .fillMaxSize()
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
    )
}