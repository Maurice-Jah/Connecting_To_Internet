package com.example.connectingtointernet

import com.example.connectingtointernet.api.ApiService

class Repository(private val apiService: ApiService) {

    suspend fun getInfo(info:String) = apiService.getInfo(info)

}