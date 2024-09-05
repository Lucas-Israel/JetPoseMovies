package br.com.lucasisrael.jetposemovies.common.navigation

import androidx.navigation.NavHostController
import br.com.lucasisrael.jetposemovies.common.navigation.Screens.DETAILS_SCREEN
import br.com.lucasisrael.jetposemovies.common.navigation.Screens.MOVIES_GENRE_SCREEN

class NavigationActions(
    private val navController: NavHostController,
) {

    fun toMovieGenreScreen() {
        navController.navigate(MOVIES_GENRE_SCREEN)
    }

    fun toDetailsScreen() {
        navController.navigate(DETAILS_SCREEN)
    }
}
