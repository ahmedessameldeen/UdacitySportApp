package com.example.chefshark.network.data.model

import com.google.gson.annotations.SerializedName

data class LeaguesResponse(
    @SerializedName("data")
    val leaguesResponse : List<League>,
    val status: Boolean
)