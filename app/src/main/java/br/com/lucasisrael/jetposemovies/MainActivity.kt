package br.com.lucasisrael.jetposemovies

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import br.com.lucasisrael.jetposemovies.common.navigation.NavGraph
import br.com.lucasisrael.jetposemovies.ui.theme.JetPoseMoviesTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetPoseMoviesTheme {
                NavGraph()
            }
        }
    }
}