package com.example.assignment_25

import com.example.assignment_25.home.network.VuNit3213ApiClient
import com.example.assignment_25.home.network.VuNit3213Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    // provides a singleton instance of VuNit3213ApiClient
    @Provides
    @Singleton
    fun provideVuNit3213ApiClient(): VuNit3213ApiClient {
        return VuNit3213ApiClient()

    }

    // Provides a singleton instance of VuNit3213Repository
    @Provides
    @Singleton
    fun provideVuNit3213Repository(apiClient: VuNit3213ApiClient): VuNit3213Repository {
        return VuNit3213Repository(apiClient)
    }
}