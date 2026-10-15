package com.example.visionapp.viewmodel

import com.example.visionapp.repository.AuthRepository

class AuthViewModel {

    private val repository = AuthRepository()

    suspend fun login(
        email: String,
        senha: String
    ) =
        repository.login(
            email,
            senha
        )
}