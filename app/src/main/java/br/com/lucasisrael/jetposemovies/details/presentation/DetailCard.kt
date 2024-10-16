package br.com.lucasisrael.jetposemovies.details.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.lucasisrael.jetposemovies.R
import br.com.lucasisrael.jetposemovies.details.data.models.domain.Details
import coil.compose.AsyncImage
import com.google.gson.Gson
import java.io.File


@SuppressWarnings("FunctionNaming")
@Composable
fun DetailCard(
    modifier: Modifier,
    details: Details
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
        ) {
            AsyncImage(
                model = "https://image.tmdb.org/t/p/w500${details.backdropPath}",
                contentDescription = "Image for the movie${details.title}",
                modifier = Modifier.fillMaxWidth(),
                placeholder = painterResource(id = R.drawable.ic_launcher_foreground),
                error = painterResource(id = R.drawable.ic_action_name)
            )
            Column()
            {
                Box() {
                    Column(
                        modifier = Modifier
                            .background(color = Color.Gray)
                    ) {
                        Text(
                            text = details.title,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            fontSize = 28.sp,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 10.dp, start = 10.dp, end = 10.dp)
                        )

                        Text(
                            text = details.tagline,
                            fontWeight = FontWeight.Light,
                            fontStyle = FontStyle.Italic,
                            color = Color.White,
                            fontSize = 12.sp,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 10.dp, start = 10.dp, end = 10.dp)
                        )
                    }
                }
                Column(
                    modifier = Modifier
                        .background(color = Color.DarkGray)
                ) {
                    Text(
                        text = details.overview,
                        fontWeight = FontWeight.Normal,
                        color = Color.White,
                        fontSize = 16.sp,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp)
                    )

                }
            }

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp)
            ) {
                Text(
                    text = "Status: " + details.status
                )
                Spacer(
                    modifier = Modifier
                        .padding(5.dp)
                )
                Text(
                    text = "Release date: " + details.releaseDate,
                )
            }

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp)
            ) {
                Column(
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    details.productionCompanies.map {
                        AsyncImage(
                            model = "https://image.tmdb.org/t/p/w500${it.logoPath}",
                            contentDescription = "${it.name} logo, a company that helped create this movie",
                            placeholder = painterResource(id = R.drawable.ic_launcher_foreground),
                            error = painterResource(id = R.drawable.ic_action_name)
                        )

                        Text(text = it.name)
                    }
                }
            }

        }
    }

}

//val jsonString =
//    File("/home/lucas/android_projects/JetPoseMovies/app/src/androidTest/java/br/com/lucasisrael/jetposemovies/resources/Details.json").readText()
//
//val detailsJson: Details = Gson().fromJson(jsonString, Details::class.java)
//
//@Preview(showBackground = true, name = "Greeting Preview")
//@Composable
//fun PreviewDetailCard() {
//    DetailCard(
//        modifier = Modifier,
//        details = detailsJson
//    )
//}
