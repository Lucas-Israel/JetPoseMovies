package br.com.lucasisrael.jetposemovies.details.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import br.com.lucasisrael.jetposemovies.R

@SuppressWarnings("FunctionNaming")
@Composable
fun ReleaseRow(
    releaseDate: String,
    modifier: Modifier
) {
    Row(
        modifier = modifier
    ) {
        Text(
            text = stringResource(R.string.release_date, releaseDate),
        )
    }

}