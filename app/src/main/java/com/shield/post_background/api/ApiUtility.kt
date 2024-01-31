package com.shield.post_background.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiUtility{
    fun getInstance(): Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://cloud.cypherx.in/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}
