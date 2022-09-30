package com.example.usgs.di

import com.example.usgs.data.EqRepositoryImpl
import com.example.usgs.data.remote.NetworkDataSource
import com.example.usgs.domain.EqRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun providesEqRepository(dataSource: NetworkDataSource): EqRepository =
        EqRepositoryImpl(dataSource)
}