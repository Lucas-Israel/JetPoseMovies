package br.com.lucasisrael.jetposemovies.common.di

import br.com.lucasisrael.jetposemovies.common.coroutines.CoroutinesProvider
import br.com.lucasisrael.jetposemovies.common.coroutines.CoroutinesProviderImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CoroutinesModule {

    @Provides
    @Singleton
    fun provideCoroutinesProvider(): CoroutinesProvider{
        return CoroutinesProviderImpl()
    }
}
