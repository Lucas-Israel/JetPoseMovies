package br.com.lucasisrael.jetposemovies.details.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.lucasisrael.jetposemovies.R

@SuppressWarnings("FunctionNaming")
@Composable
fun OverviewColumn(
    overview: String,
    modifier: Modifier
) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = stringResource(R.string.overview)
        )

        Spacer(
            modifier = Modifier
                .padding(2.dp)
        )

        Text(
            text = overview,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp,
            modifier = Modifier
                .fillMaxWidth()
        )
    }

    Spacer(
        modifier = Modifier.padding(bottom = 16.dp)
    )

}
