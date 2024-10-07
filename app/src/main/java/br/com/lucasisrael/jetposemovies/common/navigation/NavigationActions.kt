package br.com.lucasisrael.jetposemovies.common.navigation

import androidx.navigation.NavHostController
import br.com.lucasisrael.jetposemovies.common.navigation.Screens.DETAILS_SCREEN
import br.com.lucasisrael.jetposemovies.moviesgenre.MoviesGenreScreen

class NavigationActions(
    private val navController: NavHostController,
) {

    fun toMovieGenreScreen(genreId: String) {
        navController.navigate(MoviesGenreScreen(genreId))
    }

    fun toDetailsScreen() {
        navController.navigate(DETAILS_SCREEN)
    }
}
