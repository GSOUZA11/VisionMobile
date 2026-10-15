package com.example.visionapp.repository

import com.example.visionapp.api.RetrofitClient
import com.example.visionapp.model.LoginRequest

class AuthRepository {

    suspend fun login(
        email: String,
        senha: String
    ) = RetrofitClient.apiService.login(
        LoginRequest(
            email = email,
            senha = senha
        )
    )
}