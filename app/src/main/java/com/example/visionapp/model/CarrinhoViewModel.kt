package com.example.visionapp.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.visionapp.model.Oculos

class CarrinhoViewModel : ViewModel() {

    val itensCarrinho = mutableStateListOf<Oculos>()

    fun adicionarProduto(produto: Oculos) {
        itensCarrinho.add(produto)
    }

    fun removerProduto(produto: Oculos) {
        itensCarrinho.remove(produto)
    }

    fun limparCarrinho() {
        itensCarrinho.clear()
    }

    fun totalItens(): Int {
        return itensCarrinho.size
    }

    fun valorTotal(): Double {
        return itensCarrinho.sumOf { it.preco }
    }

    companion object {

        private var instance: CarrinhoViewModel? = null

        fun getInstance(): CarrinhoViewModel {

            if (instance == null) {
                instance = CarrinhoViewModel()
            }

            return instance!!
        }
    }
}