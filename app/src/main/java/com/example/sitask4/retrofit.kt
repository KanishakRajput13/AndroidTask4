package com.example.sitask4

import com.example.sitask4.api.APIService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object retrofit {
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(Utility.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api : APIService by lazy {
        retrofit.create(APIService::class.java)
    }
}