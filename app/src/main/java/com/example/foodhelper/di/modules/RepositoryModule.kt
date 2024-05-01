package com.example.foodhelper.di.modules

import com.example.data.RepositoryImpl
import com.example.domain.Repository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun getRepository(impl: RepositoryImpl): Repository
}