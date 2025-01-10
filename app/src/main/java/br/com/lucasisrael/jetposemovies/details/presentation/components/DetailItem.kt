@file:Suppress("FunctionNaming")

package br.com.lucasisrael.jetposemovies.details.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import br.com.lucasisrael.jetposemovies.common.navigation.NavigationActions
import br.com.lucasisrael.jetposemovies.common.presentation.components.CustomAsyncImage
import br.com.lucasisrael.jetposemovies.common.presentation.components.CustomCard
import br.com.lucasisrael.jetposemovies.details.models.domain.DetailsDomain

@Composable
fun DetailItem(
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
            enableGradient = true,
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
    }
}
