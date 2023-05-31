package com.jccollantes.mycats.domain.di

import com.jccollantes.mycats.data.repositories.CatsRepository
import com.jccollantes.mycats.domain.usescase.GetCatsListUseCase
import com.jccollantes.mycats.domain.usescase.GetCatsListUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun provideGetCatsListUseCase(
        catsRepository: CatsRepository
    ): GetCatsListUseCase {
        return GetCatsListUseCaseImpl(
            catsRepository
        )
    }
}