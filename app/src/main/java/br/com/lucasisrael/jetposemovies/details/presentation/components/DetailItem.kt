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
import androidx.paging.compose.LazyPagingItems
import br.com.lucasisrael.jetposemovies.R
import br.com.lucasisrael.jetposemovies.common.navigation.NavigationActions
import br.com.lucasisrael.jetposemovies.common.presentation.components.PercentageWheel
import br.com.lucasisrael.jetposemovies.details.models.domain.DetailsDomain
import coil.compose.AsyncImage

@SuppressWarnings("FunctionNaming")
@Composable
fun DetailItem(
    navigationActions: NavigationActions,
    modifier: Modifier,
    details: DetailsDomain,
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
                contentDescription = details.title?.let {
                    stringResource(
                        R.string.image_for_the_movie,
                        it
                    )
                },
                placeholder = painterResource(id = R.drawable.ic_launcher_foreground),
                error = painterResource(id = R.drawable.ic_action_name),
                modifier = Modifier
                    .fillMaxWidth()
            )

            val title = details.title ?: ""
            val tagline = details.tagline ?: ""
            TitleColumn(
                title = title,
                tagline = tagline,
                modifier = Modifier
            )


            details.genres?.let {
                GenresRow(
                    navigationActions = navigationActions,
                    genresList = it,
                )
            }

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
                    details.releaseDate?.let {
                        ReleaseRow(
                            releaseDate = it,
                            modifier = Modifier
                        )
                    }

                    details.runtime?.let {
                        RunTimeRow(
                            runtime = it,
                            modifier = Modifier
                        )
                    }

                }

                details.voteAverage?.let {
                    PercentageWheel(
                        rating = it
                    )
                }

            }

            details.overview?.let {
                OverviewColumn(
                    overview = it,
                    modifier = Modifier
                )
            }

            details.homepage?.let {
                HomepageUrl(
                    homePageUrl = it
                )
            }
        }
    }
}
