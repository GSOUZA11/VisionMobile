package com.example.visionapp.model

data class PedidoReal(
    val id: Int,
    val total: Double,
    val quantidadeItens: Int,
    val status: String,
    val data: String,
    val endereco: String
)
