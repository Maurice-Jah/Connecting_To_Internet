package com.example.connectingtointernet.api

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


//https://rickandmortyapi.com/api/character

//"https://rickandmortyapi.com/api/character?page=2

private val BASE_URL = "https://rickandmortyapi.com/api/"


interface ApiService{
    @GET("character")
    suspend fun getInfo(@Query("page")info:String):InfoResponse
}

val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

val retrofit = Retrofit.Builder().addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL).build()

object Api{
    val apiService:ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}