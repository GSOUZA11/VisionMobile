package com.example.visionapp.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.visionapp.repository.AuthRepository

class AuthViewModel : ViewModel() {

    private val repository = AuthRepository()

    var email by mutableStateOf("")
        private set

    var senha by mutableStateOf("")
        private set

    var loginState by mutableStateOf<LoginState>(
        LoginState.Idle
    )
        private set

    fun atualizarEmail(valor: String) {
        email = valor
    }

    fun atualizarSenha(valor: String) {
        senha = valor
    }

    suspend fun login(): Boolean {

        loginState = LoginState.Loading

        return try {

            val resposta = repository.login(
                email,
                senha
            )

            if (resposta.isSuccessful) {

                loginState = LoginState.Success
                true

            } else {

                loginState =
                    LoginState.Error(
                        "E-mail ou senha inválidos."
                    )

                false
            }

        } catch (e: Exception) {

            loginState =
                LoginState.Error(
                    "Erro ao conectar com o servidor."
                )

            false
        }
    }
}
