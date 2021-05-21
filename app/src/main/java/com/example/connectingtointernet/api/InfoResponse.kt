package com.example.connectingtointernet.api

import com.squareup.moshi.Json

data class InfoResponse(
    @Json(name = "results")
    val info: List<Info>
)