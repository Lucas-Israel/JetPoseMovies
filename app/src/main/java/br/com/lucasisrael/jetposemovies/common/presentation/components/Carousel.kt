package br.com.lucasisrael.jetposemovies.common.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.paging.compose.LazyPagingItems
import br.com.lucasisrael.jetposemovies.common.navigation.NavigationActions
import br.com.lucasisrael.jetposemovies.common.presentation.components.Spacing.TwoDpSpacer
import br.com.lucasisrael.jetposemovies.movies.models.domain.MovieDomain

@SuppressWarnings("FunctionNaming")
@Composable
fun Carousel(
    items: LazyPagingItems<MovieDomain>,
    navigationActions: NavigationActions
) {
    val pagerState = rememberPagerState(pageCount = { items.itemCount.coerceAtMost(5) })

    Column {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
        ) { page ->
            Box(
                contentAlignment = Alignment.TopStart,
                modifier = Modifier
                    .fillMaxSize()
                    .clickable {
                        items[page]?.id?.let { navigationActions.toDetailsScreen(it) }
                    }
            ) {
                CustomAsyncImageWithGradient(
                    url = items[page]?.posterPath,
                    title = items[page]?.title,
                    modifier = Modifier,
                    color = MaterialTheme.colorScheme.background
                )

                DescriptionTextBox(
                    releaseDate = items[page]?.releaseDate,
                    title = items[page]?.title,
                    overview = items[page]?.overview,
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                )
            }
        }
        HorizontalPagerIndicator(
            currentPage = pagerState.currentPage,
            pageCount = pagerState.pageCount,
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.CenterHorizontally)
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
    unselectedColor: Color = MaterialTheme.colorScheme.surfaceContainerHigh
) {
    Row(modifier = modifier) {
        repeat(pageCount) { index ->
            val color = if (index == currentPage) selectedColor else unselectedColor
            Surface(
                modifier = Modifier
                    .padding(8.dp)
                    .size(8.dp),
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
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = title ?: "",
            fontWeight = FontWeight.Bold,
            fontSize = 28.sp,
            modifier = Modifier

        )

        TwoDpSpacer(
            multiplier = 4
        )

        Text(
            text = releaseDate ?: ""
        )

        TwoDpSpacer(
            multiplier = 4
        )

        Text(
            text = overview ?: ""
        )
    }
}
