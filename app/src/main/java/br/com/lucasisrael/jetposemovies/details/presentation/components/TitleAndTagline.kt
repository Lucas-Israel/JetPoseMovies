package br.com.lucasisrael.jetposemovies.details.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import br.com.lucasisrael.jetposemovies.R

@SuppressWarnings("FunctionNaming")
@Composable
fun TitleAndTagline(
    title: String?,
    tagLine: String?,
    modifier: Modifier,
) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = title ?: stringResource(R.string.field_not_available),
            fontWeight = FontWeight.Bold,
            color = Color.White,
            fontSize = 28.sp,
        )

        Text(
            text = tagLine ?: stringResource(R.string.field_not_available),
            fontWeight = FontWeight.Light,
            fontStyle = FontStyle.Italic,
            color = Color.White,
            fontSize = 14.sp,
        )
    }
}