package com.example.visionapp.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.visionapp.model.Oculos
import com.example.visionapp.repository.OculosRepository

class OculosViewModel : ViewModel() {

    private val repository = OculosRepository()

    val listaOculos =
        mutableStateOf<List<Oculos>>(emptyList())

    var pesquisa = mutableStateOf("")
        private set
    var corSelecionada = mutableStateOf<String?>(null)
        private set

    var precoSelecionado = mutableStateOf<String?>(null)
        private set

    var ordenacaoSelecionada = mutableStateOf<String?>(null)
        private set

    fun atualizarPesquisa(valor: String) {
        pesquisa.value = valor
    }

    fun atualizarCor(cor: String?) {
        corSelecionada.value = cor
    }

    fun atualizarPreco(preco: String?) {
        precoSelecionado.value = preco
    }

    fun atualizarOrdenacao(ordenacao: String?) {
        ordenacaoSelecionada.value = ordenacao
    }


    suspend fun carregarOculos() {

        try {

            val resposta = repository.listarOculos()

            println("HTTP OCULOS: ${resposta.code()}")
            if (resposta.isSuccessful) {

                listaOculos.value =
                    resposta.body() ?: emptyList()

                println("QTD OCULOS: ${listaOculos.value.size}")
                println("OCULOS: ${listaOculos.value}")

            } else {

                println("ERRO HTTP: ${resposta.code()}")
                println("ERRO BODY: ${resposta.errorBody()?.string()}")

            }

        } catch (e: Exception) {

            e.printStackTrace()
            println("EXCEPTION OCULOS: ${e.message}")

        }
    }

}