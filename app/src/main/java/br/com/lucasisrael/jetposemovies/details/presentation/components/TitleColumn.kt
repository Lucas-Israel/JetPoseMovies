package br.com.lucasisrael.jetposemovies.details.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@SuppressWarnings("FunctionNaming")
@Composable
fun TitleColumn(
    title: String,
    tagline: String,
    modifier: Modifier
) {
        Column(
            modifier = modifier
        ) {
            Text(
                text = title,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                fontSize = 28.sp,
            )

            Text(
                text = tagline,
                fontWeight = FontWeight.Light,
                fontStyle = FontStyle.Italic,
                color = Color.White,
                fontSize = 12.sp,
            )
        }
}
