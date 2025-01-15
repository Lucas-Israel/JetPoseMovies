package br.com.lucasisrael.jetposemovies.common.feature.models.remote

import br.com.lucasisrael.jetposemovies.common.feature.models.local.FeatureEntity

interface FeatureDto {
    fun toEntity(): FeatureEntity
}
