package com.shield.post_background.api

import androidx.lifecycle.LiveData
import com.shield.post_background.model.BodyData
import com.shield.post_background.model.ResponseData
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiInterface {
    @POST("register")
    suspend fun getData(@Body sendData: BodyData): Response<ResponseData>
}