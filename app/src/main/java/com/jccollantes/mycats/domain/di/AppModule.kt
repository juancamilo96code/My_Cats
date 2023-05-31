package com.jccollantes.mycats.domain.di

import android.content.Context
import com.jccollantes.mycats.data.service.ApiServiceGenerator
import dagger.hilt.InstallIn
import dagger.Module
import dagger.Provides
import dagger.hilt.components.SingletonComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideApiServiceGenerator(): ApiServiceGenerator {
        return ApiServiceGenerator(
            "https://api.thecatapi.com/v1/",
            "bda53789-d59e-46cd-9bc4-2936630fde39"
        )
    }
}