@file:SuppressWarnings("FunctionNaming")

package br.com.lucasisrael.jetposemovies.movies.presentation.components

import android.content.res.Configuration
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.paging.compose.LazyPagingItems
import br.com.lucasisrael.jetposemovies.R
import br.com.lucasisrael.jetposemovies.common.navigation.NavigationActions
import br.com.lucasisrael.jetposemovies.common.presentation.components.CustomAsyncImage
import br.com.lucasisrael.jetposemovies.common.presentation.components.GradientOrientation
import br.com.lucasisrael.jetposemovies.common.utils.constants.Constants.ORIENTATION_LANDSCAPE_MULTIPLIER
import br.com.lucasisrael.jetposemovies.common.utils.constants.Constants.ORIENTATION_PORTRAIT_MULTIPLIER
import br.com.lucasisrael.jetposemovies.movies.models.domain.MovieDomain
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay

@Composable
fun UpcomingMoviesComponent(
    navigationActions: NavigationActions,
    movies: LazyPagingItems<MovieDomain>,
) {

    val configs = upcomingMoviesConfigs()

    CustomHorizontalPager(
        items = movies,
        navigationActions = navigationActions,
        configuration = configs
    )
}

@Composable
private fun CustomHorizontalPager(
    items: LazyPagingItems<MovieDomain>,
    navigationActions: NavigationActions,
    configuration: UpcomingMoviesComponentConfigs,
) {
    val pagerState =
        rememberPagerState(
            pageCount = { items.itemCount.coerceAtMost(maximumValue = 5) }
        )

    AutoScroller(pagerState = pagerState)

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HorizontalPager(
            state = pagerState,
            contentPadding = PaddingValues(horizontal = configuration.horizontalPaddingValues),
            pageSpacing = 8.dp,
            modifier = Modifier
                .fillMaxWidth()
                .height(configuration.pagerHeight)
        ) { index ->
            val item = items[index]
            if (item != null) {
                HorizontalPagerCard(
                    navigationActions = navigationActions,
                    item = item,
                    configuration = configuration
                )
            }
        }

        HorizontalPagerIndicator(
            pagerState = pagerState,
            modifier = Modifier
                .padding(top = 16.dp)
                .align(Alignment.CenterHorizontally)
        )
    }
}

@Composable
private fun AutoScroller(
    pagerState: PagerState,
    delay: Long = 3000,
    animationDuration: Int = 1000,
) {
    LaunchedEffect(
        key1 = pagerState.pageCount,
    ) {
        if (pagerState.pageCount > 1) {
            while (true) {
                delay(timeMillis = delay)
                coroutineScope {
                    val nextPage = if (pagerState.currentPage + 1 < pagerState.pageCount) {
                        pagerState.currentPage + 1
                    } else {
                        0
                    }
                    pagerState.animateScrollToPage(
                        page = nextPage,
                        animationSpec = tween(durationMillis = animationDuration)
                    )
                }
            }
        }
    }
}

@Composable
private fun HorizontalPagerCard(
    navigationActions: NavigationActions,
    item: MovieDomain,
    configuration: UpcomingMoviesComponentConfigs,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .clip(RoundedCornerShape(16.dp))
            .background(color = MaterialTheme.colorScheme.surfaceContainerHigh)
            .clickable {
                navigationActions.toDetailsScreen(item.id!!)
            }
    ) {
        CustomAsyncImage(
            url = item.posterPath,
            title = item.title,
            gradientOrientation = configuration.gradientOrientation,
            modifier = Modifier
                .width(configuration.imgWidth)
                .align(Alignment.BottomStart)
                .fillMaxSize()
        )

        DescriptionTextBox(
            releaseDate = item.releaseDate,
            title = item.title,
            overview = item.overview,
            modifier = Modifier
                .align(alignment = configuration.alignment)
                .padding(end = 8.dp)
                .width(500.dp)
        )
    }
}

@Composable
private fun HorizontalPagerIndicator(
    pagerState: PagerState,
    modifier: Modifier = Modifier,
    selectedColor: Color = MaterialTheme.colorScheme.primary,
    unselectedColor: Color = MaterialTheme.colorScheme.surfaceContainerHigh,
) {
    val currentPage by remember { derivedStateOf { pagerState.currentPage } }
    val pageCount by remember { derivedStateOf { pagerState.pageCount } }

    Row(modifier = modifier) {
        repeat(pageCount) { index ->
            val color = remember(
                index,
                currentPage
            ) { if (index == currentPage) selectedColor else unselectedColor }
            Surface(
                shape = CircleShape,
                color = color,
                modifier = Modifier
                    .padding(8.dp)
                    .size(10.dp)
                    .pointerInput(Unit) {
                        detectTapGestures(
                            onTap = {
                                pagerState.requestScrollToPage(index)
                            }
                        )
                    }
            ) {}
        }
    }
}

@Composable
private fun DescriptionTextBox(
    modifier: Modifier,
    title: String?,
    releaseDate: String?,
    overview: String?,
) {
    val fieldNotAvailable = stringResource(id = R.string.field_not_available)
    val rememberTitle = remember { title ?: fieldNotAvailable }
    val rememberReleaseDate = remember { releaseDate ?: fieldNotAvailable }
    val rememberOverView = remember { overview ?: fieldNotAvailable }

    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = modifier
            .padding(16.dp, bottom = 0.dp)
    ) {
        Text(
            text = rememberTitle,
            fontWeight = FontWeight.Bold,
            fontSize = 28.sp,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .padding(bottom = 12.dp)
        )

        Text(
            text = rememberReleaseDate,
            modifier = Modifier
                .padding(bottom = 12.dp)
        )

        Text(
            text = rememberOverView,
            maxLines = 3,
            overflow = TextOverflow.Ellipsis
        )
    }
}

/**
 * Holds configurations for UpcomingMoviesComponent, so its not necessary to set it up in every component
 *
 * @param pagerHeight HorizontalPager.Modifier.height variable height based on orientation.
 *
 * @param horizontalPaddingValues HorizontalPager.contentPadding variable padding based on orientation.
 *
 * @param gradientOrientation CustomAsyncImage.gradientOrientation nullable GradientOrientation based on orientation.
 *
 * @param imgWidth CustomAsyncImage.width variable width based on orientation.
 *
 * @param alignment DescriptionTextBox.Modifier.alignment variable alignment based on orientation
 */
private data class UpcomingMoviesComponentConfigs(
    val pagerHeight: Dp,
    val horizontalPaddingValues: Dp,
    val gradientOrientation: GradientOrientation?,
    val imgWidth: Dp,
    val alignment: Alignment,
)

/**
 * Sets all values into UpcomingMoviesComponentConfigs
 *
 * @return UpcomingMoviesComponentConfigs
 *
 * @sample UpcomingMoviesComponentConfigs
 */
@Composable
private fun upcomingMoviesConfigs(): UpcomingMoviesComponentConfigs {
    val configuration = LocalConfiguration.current
    val isLandScape =
        remember { configuration.orientation == Configuration.ORIENTATION_LANDSCAPE }
    val horizontalPaddingValues = remember {
        if (isLandScape) {
            100.dp
        } else {
            20.dp
        }
    }
    val screenHeight = remember { configuration.screenHeightDp.dp }
    val pagerHeight = remember(
        isLandScape,
        screenHeight,
        ORIENTATION_PORTRAIT_MULTIPLIER,
        ORIENTATION_LANDSCAPE_MULTIPLIER
    ) {
        if (isLandScape) {
            screenHeight * ORIENTATION_LANDSCAPE_MULTIPLIER
        } else {
            screenHeight * ORIENTATION_PORTRAIT_MULTIPLIER
        }
    }
    val color = MaterialTheme.colorScheme.background
    val gradient = remember(isLandScape) {
        if (!isLandScape) GradientOrientation.GradientBottom(color = color) else null
    }
    val imgWidth = remember(isLandScape) {
        if (isLandScape) {
            190.dp
        } else {
            500.dp
        }
    }
    val alignment = remember(isLandScape) {
        if (isLandScape) {
            Alignment.CenterEnd
        } else {
            Alignment.BottomEnd
        }
    }

    return UpcomingMoviesComponentConfigs(
        pagerHeight = pagerHeight,
        horizontalPaddingValues = horizontalPaddingValues,
        gradientOrientation = gradient,
        imgWidth = imgWidth,
        alignment = alignment
    )
}
