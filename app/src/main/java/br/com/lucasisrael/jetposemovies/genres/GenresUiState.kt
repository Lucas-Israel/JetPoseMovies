package br.com.lucasisrael.jetposemovies.genres

import br.com.lucasisrael.jetposemovies.genres.data.response.GenresResponse

data class GenresUiState(
    val isLoading: Boolean = true,
    val genres: GenresResponse? = null,
    val genresScreenState: GenresScreenState = GenresScreenState.Empty
)

sealed class GenresScreenState {
    data object Error: GenresScreenState()
    data object Empty: GenresScreenState()
    data object Success: GenresScreenState()
}
