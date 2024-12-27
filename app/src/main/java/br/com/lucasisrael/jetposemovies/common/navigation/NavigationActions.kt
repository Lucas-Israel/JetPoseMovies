package br.com.lucasisrael.jetposemovies.common.navigation

import androidx.navigation.NavHostController
import br.com.lucasisrael.jetposemovies.details.presentation.screen.DetailsScreen
import br.com.lucasisrael.jetposemovies.movies.presentation.screen.MovieListFromGenreScreen

class NavigationActions(
    private val navController: NavHostController,
) {

    fun toMovieGenreScreen(genreId: Int, genreName: String) {
        navController.navigate(MovieListFromGenreScreen(genreId, genreName))
    }

    fun toDetailsScreen(movieId: String) {
        navController.navigate(DetailsScreen(movieId = movieId))
    }
}
