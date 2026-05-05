package br.com.lucasisrael.jetposemovies.common.navigation

import androidx.navigation.NavHostController
import br.com.lucasisrael.jetposemovies.common.presentation.screens.InitialScreen
import br.com.lucasisrael.jetposemovies.common.presentation.screens.LoginScreen
import br.com.lucasisrael.jetposemovies.details.presentation.screen.DetailsScreen
import br.com.lucasisrael.jetposemovies.movies.presentation.screen.MovieListFromGenreScreen

class NavigationActions(
    private val navController: NavHostController,
) {
    fun toInitialScreen() {
        navController.navigate(InitialScreen)
    }

    fun toMovieGenreScreen(genreId: Int, genreName: String) {
        navController.navigate(MovieListFromGenreScreen(genreId, genreName))
    }

    fun toDetailsScreen(movieId: Int) {
        navController.navigate(DetailsScreen(movieId = movieId))
    }
}
