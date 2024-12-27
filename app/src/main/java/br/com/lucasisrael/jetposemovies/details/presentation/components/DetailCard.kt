package br.com.lucasisrael.jetposemovies.details.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import br.com.lucasisrael.jetposemovies.R
import br.com.lucasisrael.jetposemovies.common.navigation.NavigationActions
import br.com.lucasisrael.jetposemovies.common.presentation.components.PercentageWheel
import br.com.lucasisrael.jetposemovies.details.domain.models.Details
import coil.compose.AsyncImage

@SuppressWarnings("FunctionNaming")
@Composable
fun DetailCard(
    navigationActions: NavigationActions,
    modifier: Modifier,
    details: Details
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .fillMaxSize()
        ) {

            AsyncImage(
                model = "https://image.tmdb.org/t/p/w500${details.backdropPath}",
                contentDescription = stringResource(
                    R.string.image_for_the_movie,
                    details.title
                ),
                placeholder = painterResource(id = R.drawable.ic_launcher_foreground),
                error = painterResource(id = R.drawable.ic_action_name),
                modifier = Modifier
                    .fillMaxWidth()
            )

            TitleColumn(
                title = details.title,
                tagline = details.tagline,
                modifier = Modifier
            )

            GenresRow(
                navigationActions = navigationActions,
                genresList = details.genreDomains,
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
            )
            {
                Column(
                    verticalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .height(80.dp)
                ) {
                    ReleaseRow(
                        releaseDate = details.releaseDate,
                        modifier = Modifier
                    )

                    RunTimeRow(
                        runtime = details.runtime,
                        modifier = Modifier
                    )

                }

                PercentageWheel(
                    rating = details.voteAverage
                )

            }

            OverviewColumn(
                overview = details.overview,
                modifier = Modifier
            )

            ProductionCompanyRow(
                productionCompanies = details.productionCompanies,
                modifier = Modifier
            )

            HomepageUrl(
                homePageUrl = details.homepage
            )
        }
    }
}
