package com.jccollantes.mycats.domain.di

import com.jccollantes.mycats.data.dataSource.CatsDataSource
import com.jccollantes.mycats.data.dataSource.CatsDataSourceImpl
import com.jccollantes.mycats.data.repositories.CatsRepository
import com.jccollantes.mycats.data.repositories.CatsRepositoryImpl
import com.jccollantes.mycats.data.service.ApiServiceGenerator
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideCatsRepository(catsDataSource: CatsDataSource): CatsRepository {
        return CatsRepositoryImpl(
            catsDataSource
        )
    }
}