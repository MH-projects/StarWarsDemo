package com.mh.test.view.activity

import com.mh.domain.model.StarWarsModel

sealed class StarWarsStatus {

    object LOADING : StarWarsStatus()

    data class SUCCESS(val items: List<StarWarsModel>) : StarWarsStatus()

    data class FAILURE(val error: String) : StarWarsStatus()
}