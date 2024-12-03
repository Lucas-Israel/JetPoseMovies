package br.com.lucasisrael.jetposemovies.common.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
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

    Box(
        contentAlignment = Alignment.Center, modifier = modifier
            .fillMaxSize()
            .padding(4.dp)
    ) {

        Card(
            modifier = Modifier.fillMaxWidth(),
            elevation = CardDefaults.cardElevation(10.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.DarkGray
            )
        ) {
            CustomAsyncImage(
                url = url,
                title = title,
                modifier = modifier,
            )
        }
    }
}
