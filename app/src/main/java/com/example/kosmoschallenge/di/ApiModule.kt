package com.example.kosmoschallenge.di

import com.example.kosmoschallenge.data.api.RickMortyApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class ApiModule {
    @Provides
    @Singleton
    fun providesRickMortyApi(retrofit: Retrofit): RickMortyApi {
        return retrofit.create()
    }
}