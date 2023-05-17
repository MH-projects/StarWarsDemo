package com.mh.domain.repository

import com.mh.domain.model.StarWarsModel

interface StarWarsRepository {

    suspend fun getStarWars(): List<StarWarsModel>
}