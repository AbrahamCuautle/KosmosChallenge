package com.example.kosmoschallenge.di

import com.example.kosmoschallenge.mapper.RickMortyMapper
import com.example.kosmoschallenge.mapper.RickMortyMapperImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class MapperModule {
    @Provides
    @Singleton
    fun provideRickMortyMapper(): RickMortyMapper {
        return RickMortyMapperImpl()
    }
}