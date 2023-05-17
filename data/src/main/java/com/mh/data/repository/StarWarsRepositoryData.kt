package com.mh.data.repository

import com.mh.data.datasource.remote.StarWarsSourceRemote
import com.mh.domain.model.StarWarsModel
import com.mh.domain.repository.StarWarsRepository

class StarWarsRepositoryData(
    private val remoteDataSource: StarWarsSourceRemote
) : StarWarsRepository {

    override suspend fun getStarWars(): List<StarWarsModel> {
        return remoteDataSource.getStarWars()
    }
}