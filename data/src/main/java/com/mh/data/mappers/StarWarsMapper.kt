package com.mh.data.mappers

import com.mh.data.datasource.remote.dto.StarWarsResponse
import com.mh.domain.model.StarWarsModel

fun StarWarsResponse.toModel(): StarWarsModel {

    return StarWarsModel(
        name = this.name,
        image =this.image,
        height = this.height,
        gender = this.gender,
        species = this.species
    )
}