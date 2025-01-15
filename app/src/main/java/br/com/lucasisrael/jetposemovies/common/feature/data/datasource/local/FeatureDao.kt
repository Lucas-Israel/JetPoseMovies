package br.com.lucasisrael.jetposemovies.common.feature.data.datasource.local

import androidx.paging.PagingSource
import br.com.lucasisrael.jetposemovies.common.feature.models.local.FeatureEntity
import br.com.lucasisrael.jetposemovies.common.feature.models.remote.FeatureDto

sealed interface FeatureDao {
    fun upsert(list: List<FeatureDto>)
    fun load(): PagingSource<Int, FeatureEntity>
    fun clearAll()
    fun getCount(): Int
}
