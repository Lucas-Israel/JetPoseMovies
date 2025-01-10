package br.com.lucasisrael.jetposemovies.details.presentation.components

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import br.com.lucasisrael.jetposemovies.R

@SuppressWarnings("FunctionNaming")
@Composable
fun HomepageUrl(
    homePageUrl: String?,
    modifier: Modifier
) {
    val context = LocalContext.current

    Text(
        text = stringResource(R.string.visit_website),
        color = MaterialTheme.colorScheme.primary,
        modifier = modifier
            .clickable {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(homePageUrl))
                context.startActivity(intent)
            }
    )
}
