package com.example.visionapp.api

import com.example.visionapp.model.LoginRequest
import com.example.visionapp.model.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    @POST("login")
    suspend fun login(
        @Body request: LoginRequest
    ): Response<LoginResponse>

}