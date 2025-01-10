package br.com.lucasisrael.jetposemovies.movies.presentation.components

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.paging.compose.LazyPagingItems
import br.com.lucasisrael.jetposemovies.common.navigation.NavigationActions
import br.com.lucasisrael.jetposemovies.common.presentation.components.CustomAsyncImage
import br.com.lucasisrael.jetposemovies.common.utils.constants.Constants.ORIENTATION_LANDSCAPE_MULTIPLIER
import br.com.lucasisrael.jetposemovies.common.utils.constants.Constants.ORIENTATION_PORTRAIT_MULTIPLIER
import br.com.lucasisrael.jetposemovies.movies.models.domain.MovieDomain

@SuppressWarnings("FunctionNaming")
@Composable
fun Carousel(
    items: LazyPagingItems<MovieDomain>,
    navigationActions: NavigationActions,
) {
    val pagerState =
        rememberPagerState(pageCount = { items.itemCount.coerceAtMost(maximumValue = 5) })
    val currentPage by remember { derivedStateOf { pagerState.currentPage } }
    val pageCount by remember { derivedStateOf { pagerState.pageCount } }

    val configuration = LocalConfiguration.current
    val isLandScape = configuration.orientation == Configuration.ORIENTATION_LANDSCAPE
    val screenHeight = configuration.screenHeightDp.dp
    val horizontalPaddingValues = if (isLandScape) {
        100.dp
    } else {
        20.dp
    }
    val pagerHeight = if (isLandScape) {
        remember(screenHeight, ORIENTATION_LANDSCAPE_MULTIPLIER) {
            screenHeight * ORIENTATION_LANDSCAPE_MULTIPLIER
        }
    } else {
        remember(screenHeight, ORIENTATION_PORTRAIT_MULTIPLIER) {
            screenHeight * ORIENTATION_PORTRAIT_MULTIPLIER
        }
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HorizontalPager(
            state = pagerState,
            contentPadding = PaddingValues(horizontal = horizontalPaddingValues),
            modifier = Modifier
                .fillMaxWidth()
                .height(pagerHeight)
        ) { page ->
            val item = items[page]
            if (item != null) {
                HorizontalPagerCard(
                    navigationActions = navigationActions,
                    item = item,
                )
            }
        }

        HorizontalPagerIndicator(
            currentPage = currentPage,
            pageCount = pageCount,
            modifier = Modifier
                .padding(start = 16.dp, top = 16.dp, end = 16.dp)
                .align(Alignment.CenterHorizontally)
        )
    }
}

@SuppressWarnings("FunctionNaming")
@Composable
private fun HorizontalPagerCard(
    navigationActions: NavigationActions,
    item: MovieDomain,
) {
    val configuration = LocalConfiguration.current
    val isLandScape = configuration.orientation == Configuration.ORIENTATION_LANDSCAPE
    val imgWidth = if (isLandScape) {
        190.dp
    } else {
        500.dp
    }

    Box(
        modifier = Modifier
            .padding(start = 4.dp, end = 4.dp)
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
            enableGradient = !isLandScape,
            modifier = Modifier
                .width(imgWidth)
                .align(Alignment.BottomStart)
                .fillMaxSize()
        )

        val alignmentModifier = if (isLandScape) {
            Modifier.align(alignment = Alignment.CenterEnd)
        } else {
            Modifier.align(alignment = Alignment.BottomEnd)
        }

        DescriptionTextBox(
            releaseDate = item.releaseDate,
            title = item.title,
            overview = item.overview,
            modifier = alignmentModifier
                .padding(end = 8.dp)
                .width(500.dp)
        )
    }
}

@SuppressWarnings("FunctionNaming")
@Composable
fun HorizontalPagerIndicator(
    currentPage: Int,
    pageCount: Int,
    modifier: Modifier = Modifier,
    selectedColor: Color = MaterialTheme.colorScheme.primary,
    unselectedColor: Color = MaterialTheme.colorScheme.surfaceContainerHigh,
) {
    Row(modifier = modifier) {
        repeat(pageCount) { index ->
            val color = if (index == currentPage) selectedColor else unselectedColor
            Surface(
                modifier = Modifier
                    .padding(8.dp)
                    .size(10.dp),
                shape = CircleShape,
                color = color
            ) {}
        }
    }
}

@SuppressWarnings("FunctionNaming")
@Composable
fun DescriptionTextBox(
    modifier: Modifier,
    title: String? = "",
    releaseDate: String? = "",
    overview: String? = "",
) {
    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = modifier
            .padding(16.dp, bottom = 0.dp)
    ) {
        Text(
            text = title ?: "",
            fontWeight = FontWeight.Bold,
            fontSize = 28.sp,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .padding(bottom = 12.dp)
        )

        Text(
            text = releaseDate ?: "",
            modifier = Modifier
                .padding(bottom = 12.dp)
        )

        Text(
            text = overview ?: "",
            maxLines = 3,
            overflow = TextOverflow.Ellipsis
        )
    }
}
