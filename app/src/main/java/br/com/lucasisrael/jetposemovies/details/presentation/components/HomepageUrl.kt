package br.com.lucasisrael.jetposemovies.details.presentation.components

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@SuppressWarnings("FunctionNaming")
@Composable
fun HomepageUrl(
    homePageUrl: String,
) {
    val context = LocalContext.current

    Text(
        text = homePageUrl,
        modifier = Modifier
            .clickable {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(homePageUrl))
                context.startActivity(intent)
            }
    )

    Spacer(
        modifier = Modifier.padding(bottom = 16.dp)
    )
}
