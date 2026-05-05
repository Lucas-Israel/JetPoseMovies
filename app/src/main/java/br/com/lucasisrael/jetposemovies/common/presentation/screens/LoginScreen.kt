@file:SuppressWarnings("FunctionNaming")

package br.com.lucasisrael.jetposemovies.common.presentation.screens

import android.content.Context
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import br.com.lucasisrael.jetposemovies.common.navigation.NavigationActions
import kotlinx.serialization.Serializable
import java.io.File
import java.util.Properties

@Serializable
object LoginScreen

@Composable
fun LoginScreen(
    navigationActions: NavigationActions,
) {
    val context = LocalContext.current
    val isApi = remember { apiKeyChecker(context = context) }

    if (false) {
        navigationActions.toInitialScreen()
    } else {
        val apiKey = remember { mutableStateOf("") }

        ScreenStructure {
            LazyColumn(
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
            ) {
                items(
                    count = 1
                ) {
                    Text(text = "Insert your TheMovieDB api key.")
                    OutlinedTextField(
                        singleLine = true,
                        value = apiKey.value,
                        onValueChange = {
                            apiKey.value = it
                        },
                        modifier = Modifier
                            .width(300.dp)
                    )
                }
            }
        }
    }
}

private fun apiKeyChecker(context: Context): String {
    val localPropertiesFile = File(context.filesDir, "LoginScreen")
    val properties = Properties()
    if (localPropertiesFile.exists()) {
        properties.load(localPropertiesFile.inputStream())
    }
    Log.i("Login ---", localPropertiesFile.exists().toString())




    return localPropertiesFile.toString()
}
