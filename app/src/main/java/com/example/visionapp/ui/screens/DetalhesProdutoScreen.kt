package com.example.visionapp.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.visionapp.viewmodel.OculosViewModel
import coil.compose.AsyncImage

@Composable
fun DetalhesProdutoScreen(
    id: Int
) {

    val oculosViewModel: OculosViewModel = viewModel()

    LaunchedEffect(Unit) {
        oculosViewModel.carregarOculos()
    }

    val produto = oculosViewModel.listaOculos.value
        .find { it.id == id }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text = "Detalhes do Produto",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(
            modifier = Modifier.height(16.dp)
        )

        Text(
            text = "ID do produto: $id"
        )

        Spacer(
            modifier = Modifier.height(16.dp)
        )

        AsyncImage(
            model = "http://10.39.45.29:3000/uploads/${produto?.imagem}",
            contentDescription = produto?.nome,
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
        )

        Spacer(
            modifier = Modifier.height(16.dp)
        )

        Text(
            text = "Nome: ${produto?.nome ?: "Carregando..."}"
        )

        Text(
            text = "Categoria: ${produto?.categoria ?: ""}"
        )

        Text(
            text = "Cor: ${produto?.cor ?: ""}"
        )

        Text(
            text = "Material: ${produto?.material ?: ""}"
        )

        Text(
            text = "Preço: R$ ${produto?.preco ?: ""}"
        )
    }
}