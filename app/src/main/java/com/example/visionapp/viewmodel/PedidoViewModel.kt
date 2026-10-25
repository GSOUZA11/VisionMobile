package com.example.visionapp.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.visionapp.model.PedidoReal

class PedidoViewModel : ViewModel() {

    val pedidos = mutableStateListOf<PedidoReal>()

    fun adicionarPedido(
        pedido: PedidoReal
    ) {
        pedidos.add(pedido)
    }

    fun carregarPedidos(
        lista: List<PedidoReal>
    ) {

        pedidos.clear()

        pedidos.addAll(lista)
    }

    companion object {

        val instance =
            PedidoViewModel()
    }
}