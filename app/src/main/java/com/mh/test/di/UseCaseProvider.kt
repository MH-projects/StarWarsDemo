package com.mh.test.di

import com.mh.data.datasource.remote.Api
import com.mh.data.datasource.remote.StarWarsSourceRemote
import com.mh.data.repository.StarWarsRepositoryData
import com.mh.domain.repository.StarWarsRepository
import com.mh.domain.use_case.GetStarWarsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseProvider {

    @Provides
    @Singleton
    fun provideProductRepository(api: Api): StarWarsRepository {
        val dataSourceRemote = StarWarsSourceRemote(api)
        return StarWarsRepositoryData(dataSourceRemote)
    }

    @Provides
    @Singleton
    fun provideProductUseCase(productRepository: StarWarsRepository): GetStarWarsUseCase {
        return GetStarWarsUseCase(productRepository)
    }
}