package br.com.lucasisrael.jetposemovies.common.presentation.components

import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@SuppressWarnings("FunctionNaming")
@Composable
fun CustomCard(
    title: String? = null,
    url: String? = null,
    modifier: Modifier,
) {
    Card(
        elevation = CardDefaults.cardElevation(10.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.DarkGray
        ),
        modifier = modifier
    ) {
        CustomAsyncImage(
            url = url,
            title = title,
            modifier = Modifier
        )
    }
}
