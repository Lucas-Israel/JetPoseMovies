package br.com.lucasisrael.jetposemovies.details.di

import br.com.lucasisrael.jetposemovies.details.domain.usecase.DetailsUseCase
import br.com.lucasisrael.jetposemovies.details.domain.usecase.DetailsUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DetailsUseCaseModule {

    @Binds
    @Singleton
    fun provideDetailsUseCase(impl: DetailsUseCaseImpl): DetailsUseCase
}
