/*
 * Copyright 2018, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.example.chefshark.network.api

import com.example.chefshark.network.data.model.League
import com.example.chefshark.network.data.model.LeaguesResponse
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://api-football-standings.azharimm.site/"

/**
 * Use the Retrofit builder to build a retrofit object using a Moshi converter with our Moshi
 * object.
 */
private val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()

/**
 * A public interface that exposes the [getLeagues] method
 */
interface LeaguesApiService {
    @GET("leagues")
    suspend fun getLeagues(): LeaguesResponse
}

/**
 * A public Api object that exposes the lazy-initialized Retrofit service
 */
object LeaguesApi {
    val retrofitService : LeaguesApiService by lazy { retrofit.create(LeaguesApiService::class.java) }
}
