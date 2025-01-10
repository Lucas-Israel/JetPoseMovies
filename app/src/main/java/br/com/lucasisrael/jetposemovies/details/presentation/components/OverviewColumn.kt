package br.com.lucasisrael.jetposemovies.details.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import br.com.lucasisrael.jetposemovies.R

@SuppressWarnings("FunctionNaming")
@Composable
fun OverviewColumn(
    overview: String?,
    modifier: Modifier
) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = overview ?: stringResource(R.string.field_not_available),
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp,
            modifier = Modifier
                .fillMaxWidth()
        )
    }
}
