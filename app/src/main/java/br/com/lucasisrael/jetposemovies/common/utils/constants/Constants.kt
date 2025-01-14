package br.com.lucasisrael.jetposemovies.common.utils.constants

object Constants {
    const val BASE_URL = "https://api.themoviedb.org/3/"
    const val DETAILS_URL = "movie/{movie_id}?append_to_response=videos"
    const val GENRES_URL = "genre/movie/list?"
    const val MOVIE_BY_ID_URL = "discover/movie"
    const val NOW_PLAYING_URL = "movie/now_playing"
    const val POPULAR_URL = "movie/popular"
    const val TOP_RATED_URL = "movie/top_rated"
    const val UPCOMING_MOVIES_URL = "movie/upcoming"
    const val MINUTES_IN_HOUR = 60
    const val HALF_FLOAT = 0.5f
    const val ORIENTATION_LANDSCAPE_MULTIPLIER = 0.65f
    const val ORIENTATION_PORTRAIT_MULTIPLIER = 0.60f
    const val CUSTOM_LAZY_ROW_NAVIGATION_BUTTON_ALPHA_VALUE = 0.7f
}
