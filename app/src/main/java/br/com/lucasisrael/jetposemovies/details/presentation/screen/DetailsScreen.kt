package br.com.lucasisrael.jetposemovies.details.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import br.com.lucasisrael.jetposemovies.common.navigation.NavigationActions
import br.com.lucasisrael.jetposemovies.common.presentation.screens.LoadingScreen
import br.com.lucasisrael.jetposemovies.common.presentation.screens.ScreenStructure
import br.com.lucasisrael.jetposemovies.details.presentation.viewmodel.DetailsViewModel
import br.com.lucasisrael.jetposemovies.details.presentation.components.DetailItem
import kotlinx.serialization.Serializable

@Serializable
data class DetailsScreen(
    val movieId: Int,
)

@Suppress("FunctionNaming")
@Composable
fun DetailsScreen(
    navigationActions: NavigationActions,
    viewModel: DetailsViewModel = hiltViewModel(),
    movieId: Int,
) {
    val rememberedMovieId = remember {
        movieId
    }

    LaunchedEffect(rememberedMovieId) {
        viewModel.setFlow(movieId = rememberedMovieId)
    }

    val details = viewModel.pagingFlow.collectAsLazyPagingItems()

    if (details.loadState.refresh is LoadState.Loading) {
        LoadingScreen()
    } else {
        ScreenStructure {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                items(count = details.itemCount) { index ->
                    val detail = details[index]
                    if (detail != null) {
                        DetailItem(
                            navigationActions = navigationActions,
                            modifier = Modifier,
                            details = detail,
                        )
                    }
                }
            }
        }
    }
}
