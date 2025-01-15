package br.com.lucasisrael.jetposemovies.common.feature.models.local

import br.com.lucasisrael.jetposemovies.common.feature.models.domain.FeatureDomain

interface FeatureEntity {
    fun toDomain(): FeatureDomain
}