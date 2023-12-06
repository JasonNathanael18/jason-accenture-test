package com.example.jason_accenture_test.di

import com.example.di.qualifier.AppBaseUrl
import com.squareup.leakcanary.core.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class BaseUrlModule{
    @Provides
    @AppBaseUrl
    fun provideBaseUrl():String = "https://api.github.com/"
        //BuildConfig.base_url
}