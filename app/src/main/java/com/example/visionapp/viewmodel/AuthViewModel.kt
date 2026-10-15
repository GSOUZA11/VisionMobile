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

    var carregando by mutableStateOf(false)
        private set

    var mensagemErro by mutableStateOf("")
        private set

    fun atualizarEmail(valor: String) {
        email = valor
    }

    fun atualizarSenha(valor: String) {
        senha = valor
    }

    suspend fun login(): Boolean {

        carregando = true
        mensagemErro = ""

        return try {

            val resposta = repository.login(
                email,
                senha
            )

            carregando = false

            if (resposta.isSuccessful) {

                true

            } else {

                mensagemErro = "E-mail ou senha inválidos."
                false

            }

        } catch (e: Exception) {

            carregando = false
            mensagemErro = "Erro ao conectar com o servidor."

            false
        }
    }
}
