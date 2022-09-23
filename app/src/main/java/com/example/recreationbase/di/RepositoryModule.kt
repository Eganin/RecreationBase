package com.example.recreationbase.di

import com.example.recreationbase.data.repository.RecreationBaseRepositoryImpl
import com.example.recreationbase.domain.repository.RecreationBaseRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindRecreationBaseRepository(
        repositoryImpl: RecreationBaseRepositoryImpl
    ): RecreationBaseRepository
}