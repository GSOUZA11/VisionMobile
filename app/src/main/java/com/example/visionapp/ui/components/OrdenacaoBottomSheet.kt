package com.example.visionapp.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun OrdenacaoBottomSheet(
    ordenacaoSelecionada: String?,
    onOrdenacaoSelecionada: (String?) -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {

        Text(
            text = "Ordenar Por",
            style = MaterialTheme.typography.titleLarge
        )

        Spacer(
            modifier = Modifier.height(16.dp)
        )

        listOf(
            "MENOR_PRECO",
            "MAIOR_PRECO",
            "AZ",
            "ZA"
        ).forEach { opcao ->

            Row {

                RadioButton(
                    selected = ordenacaoSelecionada == opcao,
                    onClick = {
                        if (ordenacaoSelecionada == opcao) {
                            onOrdenacaoSelecionada(null)
                        } else {
                            onOrdenacaoSelecionada(opcao)
                        }
                    }
                )

                Text(
                    when (opcao) {
                        "MENOR_PRECO" -> "Menor preço"
                        "MAIOR_PRECO" -> "Maior preço"
                        "AZ" -> "A-Z"
                        else -> "Z-A"
                    }
                )
            }
        }
    }
}