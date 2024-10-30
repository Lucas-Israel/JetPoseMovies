package br.com.lucasisrael.jetposemovies.common.navigation

import androidx.navigation.NavHostController
import br.com.lucasisrael.jetposemovies.details.presentation.DetailsScreen
import br.com.lucasisrael.jetposemovies.moviesList.presentation.MoviesListScreen

class NavigationActions(
    private val navController: NavHostController,
) {

    fun toMovieGenreScreen(genreId: String, genreName: String) {
        navController.navigate(MoviesListScreen(genreId, genreName))
    }

    fun toDetailsScreen(movieId: String) {
        navController.navigate(DetailsScreen(movieId = movieId))
    }
}
