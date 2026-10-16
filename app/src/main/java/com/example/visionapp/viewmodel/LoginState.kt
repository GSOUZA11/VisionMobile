package com.example.visionapp.viewmodel

sealed class LoginState {

    data object Idle : LoginState()

    data object Loading : LoginState()

    data object Success : LoginState()

    data class Error(
        val mensagem: String
    ) : LoginState()
}