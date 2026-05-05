@file:Suppress("FunctionNaming")

package br.com.lucasisrael.jetposemovies.details.presentation.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import br.com.lucasisrael.jetposemovies.common.navigation.NavigationActions
import br.com.lucasisrael.jetposemovies.common.presentation.components.CustomAsyncImage
import br.com.lucasisrael.jetposemovies.common.presentation.components.CustomCard
import br.com.lucasisrael.jetposemovies.common.presentation.components.GradientOrientation
import br.com.lucasisrael.jetposemovies.details.models.domain.DetailsDomain

@Composable
fun DetailItem(
    navigationActions: NavigationActions,
    details: DetailsDomain,
) {
    val orientation = LocalConfiguration.current.orientation
    val isLandscape = orientation == Configuration.ORIENTATION_LANDSCAPE

    if (isLandscape) {
        LandscapeDetail(
            navigationActions = navigationActions,
            details = details
        )
    } else {
        PortraitDetail(
            navigationActions = navigationActions,
            details = details
        )
    }
}

@Composable
private fun LandscapeDetail(
    navigationActions: NavigationActions,
    details: DetailsDomain,
) {
    val standardPaddingModifier = Modifier.padding(top = 8.dp, bottom = 8.dp)
    Card(
        colors = CardColors(
            containerColor = MaterialTheme.colorScheme.background,
            contentColor = MaterialTheme.colorScheme.onSurface,
            disabledContainerColor = MaterialTheme.colorScheme.secondaryContainer,
            disabledContentColor = MaterialTheme.colorScheme.secondary
        ),
        modifier = Modifier
            .clip(shape = RoundedCornerShape(16.dp))
            .padding(start = 100.dp, bottom = 50.dp, end = 100.dp)
            .fillMaxSize()
    ) {
        ImageRow(
            details = details,
            modifier = Modifier
                .fillMaxSize()
        )
        TitleAndTagline(
            title = details.title,
            tagLine = details.tagline,
            modifier = standardPaddingModifier
        )
        GenresRow(
            genres = details.genres,
            navigationActions = navigationActions,
            modifier = standardPaddingModifier
        )
        RunTimeRow(
            runtime = details.runtime,
            modifier = standardPaddingModifier
        )
        ReleaseRow(
            releaseDate = details.releaseDate,
            modifier = standardPaddingModifier
        )
        OverviewColumn(
            overview = details.overview,
            modifier = standardPaddingModifier
        )
        HomepageUrl(
            homePageUrl = details.homepage,
            modifier = standardPaddingModifier
        )
        VideosPlayer(
            videos = details.videos
        )
    }
}

@Composable
private fun ImageRow(
    details: DetailsDomain,
    modifier: Modifier
) {
    Row(
        modifier = modifier
    ) {
        CustomAsyncImage(
            url = details.posterPath,
            title = details.title,
            gradientOrientation = GradientOrientation.GradientEnd(color = MaterialTheme.colorScheme.background),
            modifier = Modifier
        )
        CustomAsyncImage(
            url = details.backdropPath,
            title = details.title,
            gradientOrientation = GradientOrientation.GradientStart(color = MaterialTheme.colorScheme.background),
            modifier = Modifier
                .fillMaxSize()
        )
    }
}

@Composable
private fun PortraitDetail(
    navigationActions: NavigationActions,
    details: DetailsDomain,
) {
    val standardPaddingModifier = Modifier.padding(top = 8.dp, bottom = 8.dp)
    Column(
        modifier = Modifier
            .clip(shape = RoundedCornerShape(16.dp))
            .padding(bottom = 50.dp)
    ) {
        CustomAsyncImage(
            url = details.backdropPath,
            title = details.title,
            gradientOrientation = GradientOrientation.GradientBottom(color = MaterialTheme.colorScheme.background),
            modifier = Modifier
                .fillMaxSize()
        )
        CustomCard(
            url = details.posterPath,
            title = details.title,
            modifier = standardPaddingModifier
                .align(Alignment.CenterHorizontally)
        )
        TitleAndTagline(
            title = details.title,
            tagLine = details.tagline,
            modifier = standardPaddingModifier
        )
        GenresRow(
            genres = details.genres,
            navigationActions = navigationActions,
            modifier = standardPaddingModifier
        )
        RunTimeRow(
            runtime = details.runtime,
            modifier = standardPaddingModifier
        )
        ReleaseRow(
            releaseDate = details.releaseDate,
            modifier = standardPaddingModifier
        )
        OverviewColumn(
            overview = details.overview,
            modifier = standardPaddingModifier
        )
        HomepageUrl(
            homePageUrl = details.homepage,
            modifier = standardPaddingModifier
        )
        VideosPlayer(
            videos = details.videos
        )
    }
}
