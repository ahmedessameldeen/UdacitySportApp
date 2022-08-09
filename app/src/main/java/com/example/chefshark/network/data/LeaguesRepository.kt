package com.example.chefshark.network.data

import com.example.chefshark.network.api.LeaguesApi
import com.example.chefshark.network.data.model.League
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LeaguesRepository() {

    suspend fun getLeagues(): List<League> {
        return withContext(Dispatchers.IO) {
            return@withContext LeaguesApi.retrofitService.getLeagues().leaguesResponse
        }
    }
}