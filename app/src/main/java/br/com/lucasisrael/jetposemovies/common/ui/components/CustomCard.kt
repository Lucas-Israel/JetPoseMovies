package br.com.lucasisrael.jetposemovies.common.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.lucasisrael.jetposemovies.R
import coil.compose.AsyncImage

@SuppressWarnings("FunctionNaming")
@Composable
fun CustomCard(
    title: String,
    url: String? = "",
    rating: Double? = null,
    modifier: Modifier,
) {

    val color = Color.Black
    val halfFloat = 0.5f

    Box(
        contentAlignment = Alignment.Center, modifier = modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {

        Card(
            modifier = Modifier.fillMaxWidth(),
            elevation = CardDefaults.cardElevation(10.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.DarkGray
            )
        ) {

            Box(
                contentAlignment = Alignment.BottomEnd,
                modifier = modifier
                    .fillMaxSize()
                    .padding(top = 8.dp, start = 8.dp, end = 8.dp)
            ) {

                AsyncImage(
                    model = stringResource(R.string.image_base_url, url!!),
                    contentDescription = stringResource(R.string.movie_image_from_the_genre, title),
                    contentScale = ContentScale.Crop,
                    placeholder = painterResource(id = R.drawable.ic_launcher_foreground),
                    error = painterResource(id = R.drawable.ic_action_name),
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp))
                        .drawWithCache {
                            onDrawWithContent {
                                drawContent()
                                drawRect(
                                    Brush.verticalGradient(
                                        halfFloat to color.copy(alpha = 0f),
                                        1f to color
                                    )
                                )
                            }
                        }
                )

                if (rating != null) {
                    PercentageWheel(
                        rating = rating
                    )
                }
            }

            Box(
                contentAlignment = Alignment.Center,
                modifier = modifier
                    .fillMaxSize()
                    .padding(bottom = 8.dp, start = 8.dp, end = 8.dp)
                    .clip(
                        RoundedCornerShape(
                            bottomStart = 8.dp,
                            bottomEnd = 8.dp
                        )
                    )
                    .background(color)
            ) {
                Text(
                    text = title,
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                    modifier = Modifier
                        .padding(10.dp)
                )
            }
        }
    }
}
