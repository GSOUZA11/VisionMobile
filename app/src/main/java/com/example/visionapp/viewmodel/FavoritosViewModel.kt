package com.example.visionapp.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.visionapp.model.Oculos

class FavoritosViewModel : ViewModel() {

    val favoritos = mutableStateListOf<Oculos>()

    fun adicionar(oculos: Oculos) {

        if (!favoritos.any { it.id == oculos.id }) {
            favoritos.add(oculos)
        }

    }

    fun remover(oculos: Oculos) {

        favoritos.removeIf {
            it.id == oculos.id
        }

    }

    fun estaFavoritado(id: Int): Boolean {

        return favoritos.any {
            it.id == id
        }

    }

    companion object {

        val instance = FavoritosViewModel()

    }
}