package com.example.visionapp.model

data class Oculos(
    val id: Int,
    val nome: String,
    val descricao: String,
    val categoria: String,
    val cor: String,
    val tamanho: String,
    val preco: Double,
    val estoque: Int,
    val imagem: String,
    val ativo: Boolean,
    val marca: String?,
    val grau: String?,
    val material: String?
)