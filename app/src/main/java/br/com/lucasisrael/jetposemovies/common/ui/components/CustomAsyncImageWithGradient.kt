package br.com.lucasisrael.jetposemovies.common.ui.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import br.com.lucasisrael.jetposemovies.R
import coil.compose.AsyncImage

@SuppressWarnings("FunctionNaming")
@Composable
fun CustomAsyncImageWithGradient(
    url: String,
    title: String,
    modifier: Modifier,
    color: Color
){
    val halfFloat = 0.5f

    AsyncImage(
        model = stringResource(R.string.image_base_url, url),
        contentDescription = stringResource(R.string.movie_image_from_the_genre, title),
        contentScale = ContentScale.Crop,
        placeholder = painterResource(id = R.drawable.ic_launcher_foreground),
        error = painterResource(id = R.drawable.ic_action_name),
        modifier = modifier
            .fillMaxSize()
            .clip(RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp))
            .drawWithCache {
                onDrawWithContent {
                    drawContent()
                    drawRect(
                        Brush.verticalGradient(
                            halfFloat to color.copy(alpha = 0f),
                            1f to color
                        )
                    )
                }
            }
    )
}