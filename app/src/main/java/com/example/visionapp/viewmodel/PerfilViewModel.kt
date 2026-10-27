package com.example.visionapp.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.visionapp.model.Usuario
import com.example.visionapp.repository.PerfilRepository
import kotlinx.coroutines.launch
import com.example.visionapp.model.AtualizarPerfilRequest

class PerfilViewModel : ViewModel() {

    private val repository = PerfilRepository()

    var usuario = mutableStateOf<Usuario?>(null)

    fun carregarPerfil() {

        viewModelScope.launch {

            try {

                val resposta = repository.buscarPerfil()

                println("STATUS PERFIL: ${resposta.code()}")

                if (resposta.isSuccessful) {

                    println("PERFIL OK")
                    println("BODY: ${resposta.body()}")

                    usuario.value = resposta.body()

                } else {

                    println("ERRO PERFIL")
                    println("CODIGO: ${resposta.code()}")
                    println("ERRO: ${resposta.errorBody()?.string()}")

                }

            } catch (e: Exception) {

                e.printStackTrace()

            }
        }
    }
    fun atualizarPerfil(
        nome: String,
        email: String,
        telefone: String,
        onSuccess: () -> Unit
    ) {

        viewModelScope.launch {

            try {

                val resposta = repository.atualizarPerfil(
                    AtualizarPerfilRequest(
                        nome = nome,
                        email = email,
                        telefone = telefone
                    )
                )

                if (resposta.isSuccessful) {

                    println("PERFIL ATUALIZADO COM SUCESSO")

                    carregarPerfil()

                    onSuccess()

                } else {

                    println("ERRO ATUALIZAR PERFIL")
                    println("CODIGO: ${resposta.code()}")
                    println("BODY: ${resposta.errorBody()?.string()}")
                }

            } catch (e: Exception) {

                e.printStackTrace()

            }

        }

    }
}