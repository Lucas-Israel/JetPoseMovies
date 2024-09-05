package br.com.lucasisrael.jetposemovies.common.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.lucasisrael.jetposemovies.details.DetailsScreen
import br.com.lucasisrael.jetposemovies.genres.GenresScreen
import br.com.lucasisrael.jetposemovies.moviesgenre.MoviesGenreScreen

@Composable
fun NavGraph() {

    val navController = rememberNavController()
    val navActions = NavigationActions(navController)

    NavHost(
        navController = navController,
        startDestination = GenresScreen,
    ) {

        composable<GenresScreen> {
            GenresScreen(navigationActions = navActions)
        }

        composable<MoviesGenreScreen> {
            MoviesGenreScreen(navigationActions = navActions)
        }

        composable<DetailsScreen> {
            DetailsScreen()
        }
    }

}
