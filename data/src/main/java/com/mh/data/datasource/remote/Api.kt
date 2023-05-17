package com.mh.data.datasource.remote

import com.mh.data.datasource.remote.dto.StarWarsResponse
import retrofit2.Response
import retrofit2.http.GET

interface Api {

    @GET(PATH.GET_STAR_WARS)
    suspend fun getStarWars(): Response<List<StarWarsResponse>>
}