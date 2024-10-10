package br.com.lucasisrael.jetposemovies.common.navigation

import androidx.navigation.NavHostController
import br.com.lucasisrael.jetposemovies.common.navigation.Screens.DETAILS_SCREEN
import br.com.lucasisrael.jetposemovies.moviesgenre.presentation.MoviesGenreScreen

class NavigationActions(
    private val navController: NavHostController,
) {

    fun toMovieGenreScreen(genreId: String, genreName: String) {
        navController.navigate(MoviesGenreScreen(genreId, genreName))
    }

    fun toDetailsScreen() {
        navController.navigate(DETAILS_SCREEN)
    }
}
