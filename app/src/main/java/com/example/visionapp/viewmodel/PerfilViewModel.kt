package com.example.visionapp.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.visionapp.model.Usuario
import com.example.visionapp.repository.PerfilRepository
import kotlinx.coroutines.launch

class PerfilViewModel : ViewModel() {

    private val repository = PerfilRepository()

    var usuario = mutableStateOf<Usuario?>(null)

    fun carregarPerfil() {

        viewModelScope.launch {

            try {

                val resposta = repository.buscarPerfil()

                if (resposta.isSuccessful) {
                    usuario.value = resposta.body()
                }

            } catch (e: Exception) {
                e.printStackTrace()
            }

        }
    }
}