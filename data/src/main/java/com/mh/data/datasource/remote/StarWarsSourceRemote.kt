package com.mh.data.datasource.remote

import com.mh.data.mappers.toModel
import com.mh.domain.model.StarWarsModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class StarWarsSourceRemote(private val api: Api) {

    suspend fun getStarWars(): List<StarWarsModel> {

        return withContext(Dispatchers.IO) {
            val response = api.getStarWars()
            response.body()!!.map { it.toModel() }
        }
    }
}