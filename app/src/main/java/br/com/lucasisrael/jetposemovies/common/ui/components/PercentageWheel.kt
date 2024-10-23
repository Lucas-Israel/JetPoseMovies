package br.com.lucasisrael.jetposemovies.common.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@SuppressWarnings("FunctionNaming")
@Composable
fun PercentageWheel(
    rating: Double,
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .padding(8.dp)
            .size(80.dp)
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.background)
    ) {
        CircularProgressIndicator(
            progress = {
                (rating / 10).toFloat()
            },
            color = Color.Green,
            strokeWidth = 4.dp,
            modifier = Modifier
                .fillMaxSize()
                .padding(6.dp)
        )

        Text(
            text = (rating * 10).toInt().toString() + "%",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier
                .align(Alignment.Center)
        )
    }
}
