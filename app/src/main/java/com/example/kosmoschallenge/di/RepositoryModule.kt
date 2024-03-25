package com.example.kosmoschallenge.di

import com.example.kosmoschallenge.data.repository.RickMortyRepository
import com.example.kosmoschallenge.data.repository.RickMortyRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindRickMortyRepository(rickMortyRepository: RickMortyRepositoryImpl): RickMortyRepository
}