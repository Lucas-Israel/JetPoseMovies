package br.com.lucasisrael.jetposemovies.common.feature.data.api

import br.com.lucasisrael.jetposemovies.common.feature.models.remote.FeatureDto

sealed interface FeatureApi {
    suspend fun fetch(): List<FeatureDto>
}
