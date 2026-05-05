@file:SuppressWarnings("FunctionNaming")

package br.com.lucasisrael.jetposemovies.movies.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.paging.compose.LazyPagingItems
import br.com.lucasisrael.jetposemovies.R
import br.com.lucasisrael.jetposemovies.common.navigation.NavigationActions
import br.com.lucasisrael.jetposemovies.common.presentation.components.CustomCard
import br.com.lucasisrael.jetposemovies.common.utils.constants.Constants.CUSTOM_LAZY_ROW_NAVIGATION_BUTTON_ALPHA_VALUE
import br.com.lucasisrael.jetposemovies.movies.models.domain.MovieDomain
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun CustomLazyRow(
    movies: LazyPagingItems<MovieDomain>,
    navigationActions: NavigationActions,
    categoryText: String,
) {
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        Text(
            text = categoryText,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        )
        Box(
            contentAlignment = Alignment.BottomCenter,
            modifier = Modifier
        ){
            LazyRow(
                state = listState,
                modifier = Modifier
                    .height(290.dp)
            ) {
                items(count = movies.itemCount) { index ->
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(4.dp)
                    ) {
                        val movie = movies[index]
                        if (movie != null) {
                            CustomCard(
                                title = movie.title,
                                url = movie.posterPath,
                                modifier = Modifier
                                    .fillMaxSize()
                                    .clickable {
                                        navigationActions.toDetailsScreen(movieId = movie.id!!)
                                    }
                            )
                        }
                    }
                }
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .padding(4.dp)
                    .fillMaxWidth()
            ) {
                PreviousButton(coroutineScope, listState, categoryText)
                NextButton(coroutineScope, listState, categoryText)
            }
        }
    }
}

@Composable
private fun PreviousButton(
    coroutineScope: CoroutineScope,
    listState: LazyListState,
    categoryText: String,
) {
    val currItem = remember { derivedStateOf { listState.firstVisibleItemIndex } }.value
    Button(
        colors = ButtonColors(
            containerColor = MaterialTheme.colorScheme.surfaceContainerHigh,
            contentColor = MaterialTheme.colorScheme.onSurfaceVariant,
            disabledContainerColor = MaterialTheme.colorScheme.secondaryContainer,
            disabledContentColor = MaterialTheme.colorScheme.secondary
        ),
        shape = CircleShape,
        onClick = {
            coroutineScope.launch {
                val checkedVal = if (currItem <= 0) 0 else currItem - 1
                listState.animateScrollToItem(index = checkedVal)
            }
        },
        modifier = Modifier
            .alpha(alpha = CUSTOM_LAZY_ROW_NAVIGATION_BUTTON_ALPHA_VALUE)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_back_arrow),
            contentDescription = stringResource(R.string.previous_item_on_the_list, categoryText),
            modifier = Modifier
        )
    }
}

@Composable
fun NextButton(
    coroutineScope: CoroutineScope,
    listState: LazyListState,
    categoryText: String,
) {
    val currItem = remember { derivedStateOf { listState.firstVisibleItemIndex } }.value
    val lastItemIndex = remember { derivedStateOf { listState.layoutInfo.totalItemsCount } }.value
    Button(
        colors = ButtonColors(
            containerColor = MaterialTheme.colorScheme.surfaceContainerHigh,
            contentColor = MaterialTheme.colorScheme.onSurfaceVariant,
            disabledContainerColor = MaterialTheme.colorScheme.secondaryContainer,
            disabledContentColor = MaterialTheme.colorScheme.secondary
        ),
        shape = CircleShape,
        onClick = {
            coroutineScope.launch {
                val checkedVal = if (currItem >= lastItemIndex) lastItemIndex else currItem + 1
                listState.animateScrollToItem(index = checkedVal)
            }
        },
        modifier = Modifier
            .alpha(alpha = CUSTOM_LAZY_ROW_NAVIGATION_BUTTON_ALPHA_VALUE)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_forward_arrow),
            contentDescription = stringResource(R.string.next_item_on_the_list, categoryText),
            modifier = Modifier
        )
    }
}
