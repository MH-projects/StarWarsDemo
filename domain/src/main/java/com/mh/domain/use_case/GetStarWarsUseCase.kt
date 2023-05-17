package com.mh.domain.use_case

import com.mh.domain.model.StarWarsModel
import com.mh.domain.repository.StarWarsRepository

class GetStarWarsUseCase(private val repository: StarWarsRepository) {

    suspend operator fun invoke(): List<StarWarsModel> = repository.getStarWars()
}