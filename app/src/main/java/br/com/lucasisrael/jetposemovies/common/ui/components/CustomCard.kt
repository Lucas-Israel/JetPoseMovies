package br.com.lucasisrael.jetposemovies.common.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.lucasisrael.jetposemovies.R
import coil.compose.AsyncImage
import java.math.BigDecimal
import java.math.RoundingMode

@SuppressWarnings("FunctionNaming")
@Composable
fun CustomCard(
    title: String,
    url: String? = "",
    rating: Double? = null,
    modifier: Modifier,
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {

        Card(
            modifier = Modifier
                .fillMaxWidth(),
            elevation = CardDefaults.cardElevation(10.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.DarkGray
            )
        ) {
            Column(
                modifier = Modifier.fillMaxSize()
            ) {

                if (rating != null) {
                    Text(
                        text = stringResource(
                            R.string.rating,
                            BigDecimal(rating).setScale(1, RoundingMode.UP).toDouble()
                        ),
                        modifier = Modifier
                            .padding(10.dp)
                            .fillMaxWidth(),
                        fontWeight = FontWeight.Bold,
                        fontSize = 24.sp,
                        textAlign = TextAlign.Right
                    )
                }

                AsyncImage(
                    model = stringResource(R.string.image_base_url, url!!),
                    contentDescription = stringResource(R.string.movie_image_from_the_genre, title),
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxWidth(),
                    placeholder = painterResource(id = R.drawable.ic_launcher_foreground),
                    error = painterResource(id = R.drawable.ic_action_name)
                )
                Text(
                    text = title,
                    modifier = Modifier.padding(10.dp),
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                )
            }
        }
    }
}
