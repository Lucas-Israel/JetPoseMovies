package br.com.lucasisrael.jetposemovies.details.domain.usecase

import br.com.lucasisrael.jetposemovies.details.domain.models.Details

interface DetailsUseCase {
    suspend operator fun invoke(movieId: String): Details
}
