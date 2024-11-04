package br.com.lucasisrael.jetposemovies.common.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import br.com.lucasisrael.jetposemovies.common.presentation.screens.InitialScreen
import br.com.lucasisrael.jetposemovies.details.presentation.screen.DetailsScreen
import br.com.lucasisrael.jetposemovies.movies.presentation.screen.MovieListFromGenreScreen

@Suppress("FunctionNaming")
@Composable
fun NavGraph() {

    val navController = rememberNavController()
    val navActions = NavigationActions(navController)

    NavHost(
        navController = navController,
        startDestination = InitialScreen,
    ) {

        composable<InitialScreen> {
            InitialScreen(navigationActions = navActions)
        }

        composable<MovieListFromGenreScreen> {
            val args = it.toRoute<MovieListFromGenreScreen>()
            MovieListFromGenreScreen(
                navigationActions = navActions,
                genreId = args.genreId,
                genreName = args.genreName
            )
        }

        composable<DetailsScreen> {
            val args = it.toRoute<DetailsScreen>()
            DetailsScreen(
                navigationActions = navActions,
                movieId = args.movieId
            )
        }
    }

}
