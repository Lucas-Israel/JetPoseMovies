@file:Suppress("FunctionNaming")

package br.com.lucasisrael.jetposemovies.common.presentation.components

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import br.com.lucasisrael.jetposemovies.R
import br.com.lucasisrael.jetposemovies.common.utils.constants.Constants.HALF_FLOAT
import coil.compose.AsyncImage

@Composable
fun CustomAsyncImage(
    url: String?,
    title: String?,
    modifier: Modifier,
    gradientOrientation: GradientOrientation? = null,
) {
    val modified = remember {
        gradientOrientationModifier(
            gradientOrientation = gradientOrientation,
            modifier = modifier,
        )
    }

    AsyncImage(
        model = stringResource(
            R.string.image_base_url,
            url ?: stringResource(id = R.string.field_not_available)
        ),
        contentDescription = stringResource(
            R.string.movie_image_from_the_genre,
            title ?: stringResource(id = R.string.field_not_available)
        ),
        placeholder = painterResource(id = R.drawable.ic_launcher_foreground),
        error = painterResource(id = R.drawable.ic_action_name),
        contentScale = ContentScale.FillWidth,
        modifier = modified
    )
}

sealed class GradientOrientation {
    abstract fun getBrush(): Brush

    data class GradientBottom(val color: Color) : GradientOrientation() {
        override fun getBrush(): Brush {
            return customBrush(
                color = color,
                start = 0f,
                end = Float.POSITIVE_INFINITY,
            )
        }
    }

    data class GradientTop(val color: Color) : GradientOrientation() {
        override fun getBrush(): Brush {
            return customBrush(
                color = color,
                start = Float.POSITIVE_INFINITY,
                end = 0f
            )
        }
    }

    data class GradientStart(val color: Color) : GradientOrientation() {
        override fun getBrush(): Brush {
            return customBrush(
                isVertical = false,
                color = color,
                start = Float.POSITIVE_INFINITY,
                end = 0f
            )
        }
    }

    data class GradientEnd(val color: Color) : GradientOrientation() {
        override fun getBrush(): Brush {
            return customBrush(
                isVertical = false,
                color = color,
                start = 0f,
                end = Float.POSITIVE_INFINITY
            )
        }
    }
}

@SuppressLint("ModifierFactoryExtensionFunction")
// this lint doesn't make sense, this return does have access to Modifier methods.
private fun gradientOrientationModifier(
    gradientOrientation: GradientOrientation?,
    modifier: Modifier,
): Modifier {
    return if (gradientOrientation != null) {
        modifier
            .drawWithCache {
                onDrawWithContent {
                    drawContent()
                    drawRect(
                        gradientOrientation.getBrush()
                    )
                }
            }
    } else {
        modifier
    }
}

private fun customBrush(
    color: Color,
    start: Float,
    end: Float,
    isVertical: Boolean = true,
): Brush {
    return if (isVertical) {
        Brush.verticalGradient(
            HALF_FLOAT to color.copy(alpha = 0.25f),
            2f to color,
            startY = start,
            endY = end,
        )
    } else {
        Brush.horizontalGradient(
            HALF_FLOAT to color.copy(alpha = 0.25f),
            2f to color,
            startX = start,
            endX = end
        )
    }
}
