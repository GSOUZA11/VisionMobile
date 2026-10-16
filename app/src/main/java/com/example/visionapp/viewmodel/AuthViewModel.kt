package com.example.visionapp.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.visionapp.repository.AuthRepository
import com.example.visionapp.model.LoginResponse

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

    var loginResponse by mutableStateOf<LoginResponse?>(null)
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

            println("CODIGO HTTP: ${resposta.code()}")

            if (resposta.isSuccessful) {

                loginResponse = resposta.body()
                println("LOGIN OK")
                println("BODY: ${resposta.body()}")

                loginState = LoginState.Success
                true

            } else {

                println("CODIGO HTTP: ${resposta.code()}")
                println("BODY ERRO: ${resposta.errorBody()?.string()}")

                loginState =
                    LoginState.Error(
                        "E-mail ou senha inválidos."
                    )

                false
            }

        } catch (e: Exception) {

            e.printStackTrace()

            println("EXCEPTION: ${e.message}")

            loginState =
                LoginState.Error(
                    "Erro ao conectar com o servidor."
                )

            false
        }
    }
}
