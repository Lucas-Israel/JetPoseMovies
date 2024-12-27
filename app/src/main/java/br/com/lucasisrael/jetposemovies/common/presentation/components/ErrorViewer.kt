package br.com.lucasisrael.jetposemovies.common.presentation.components

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import br.com.lucasisrael.jetposemovies.movies.models.domain.MovieDomain

@Suppress("FunctionNaming")
@Composable
fun ErrorViewer(movies: LazyPagingItems<MovieDomain>) {
    val context = LocalContext.current
    LaunchedEffect(key1 = movies.loadState) {
        if (movies.loadState.refresh is LoadState.Error) {
            Toast.makeText(
                context,
                "Error: " + (movies.loadState.refresh as LoadState.Error).error.message,
                Toast.LENGTH_LONG
            ).show()
        }
    }
}
