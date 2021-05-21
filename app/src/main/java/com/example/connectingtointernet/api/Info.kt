package com.example.connectingtointernet.api

import com.squareup.moshi.Json

class Info (

    @Json(name = "name")
    val infoName: String,

    @Json(name = "status")
    val infoStatus: String,

    @Json(name = "species")
    val infoSpecies: String,

    @Json(name = "image")
    val infoImage: String
        )



//"results":[{"id":1,
// "name":"Rick Sanchez","status":"Alive",
// "species":"Human","type":"","gender":"Male","origin":
// {"name":"Earth (C-137)","url":"https://rickandmortyapi.com/api/location/1"},"location":
// {"name":"Earth (Replacement Dimension)","url":"https://rickandmortyapi.com/api/location/20"},
// "image":"https://rickandmortyapi.com/api/character/avatar/1.jpeg","episode":


