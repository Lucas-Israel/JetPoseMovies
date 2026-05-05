package br.com.lucasisrael.jetposemovies.details.presentation.components

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import br.com.lucasisrael.jetposemovies.R

@SuppressWarnings("FunctionNaming")
@Composable
fun ReleaseRow(
    releaseDate: String?,
    modifier: Modifier
) {
    Row(
        modifier = modifier
    ) {
        Text(
            text = stringResource(
                R.string.release_date,
                releaseDate ?: stringResource(R.string.field_not_available)
            ),
        )
    }

}