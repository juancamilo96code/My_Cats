package com.jccollantes.mycats.domain.di

import android.content.Context
import com.jccollantes.mycats.data.dataSource.CatsDataSource
import com.jccollantes.mycats.data.dataSource.CatsDataSourceImpl
import com.jccollantes.mycats.data.service.ApiServiceGenerator
import dagger.hilt.InstallIn
import dagger.Module
import dagger.Provides
import dagger.hilt.components.SingletonComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    @Provides
    @Singleton
    fun provideCatsDataSource(apiServiceGenerator: ApiServiceGenerator): CatsDataSource {
        return CatsDataSourceImpl(
            apiServiceGenerator
        )
    }
}