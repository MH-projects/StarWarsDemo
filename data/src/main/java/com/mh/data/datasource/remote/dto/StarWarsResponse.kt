package com.mh.data.datasource.remote.dto

import com.squareup.moshi.Json

data class StarWarsResponse(

    @field: Json(name = "name")
    var name: String,

    @field: Json(name = "image")
    var image: String,

    @field: Json(name = "gender")
    var gender: String,

    @field: Json(name = "height")
    var height: Double,

    @field: Json(name = "species")
    var species: String,
)