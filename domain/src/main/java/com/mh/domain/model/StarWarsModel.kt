package com.mh.domain.model

import java.io.Serializable

data class StarWarsModel(
    val name: String,
    val image: String,
    val height: Double,
    val gender: String,
    val species: String,
) : Serializable