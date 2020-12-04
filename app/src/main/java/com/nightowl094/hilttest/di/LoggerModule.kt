package com.nightowl094.hilttest.di

import com.nightowl094.hilttest.utils.Logger
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
object LoggerModule {

    @Singleton
    @Provides
    fun provideLogger(): Logger = Logger()

}