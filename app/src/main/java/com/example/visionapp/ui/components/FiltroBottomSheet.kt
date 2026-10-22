package com.example.visionapp.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun FiltroBottomSheet(
    corSelecionada: String?,
    precoSelecionado: String?,
    onCorSelecionada: (String?) -> Unit,
    onPrecoSelecionado: (String?) -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {

        Text(
            text = "Filtrar Produtos",
            style = MaterialTheme.typography.titleLarge
        )

        Spacer(
            modifier = Modifier.height(16.dp)
        )

        Text("Cor")

        listOf(
            "Preto",
            "Dourado",
            "Prata",
            "Marrom",
            "Cinza"
        ).forEach { cor ->

            Row {

                RadioButton(
                    selected = corSelecionada == cor,
                    onClick = {
                        if (corSelecionada == cor) {
                            onCorSelecionada(null)
                        } else {
                            onCorSelecionada(cor)
                        }
                    }
                )

                Text(cor)
            }
        }

        Spacer(
            modifier = Modifier.height(16.dp)
        )

        Text("Preço")

        listOf(
            "ATE_200",
            "200_500",
            "500_1000",
            "ACIMA_1000"
        ).forEach { faixa ->

            Row {

                RadioButton(
                    selected = precoSelecionado == faixa,
                    onClick = {
                        if (precoSelecionado == faixa) {
                            onPrecoSelecionado(null)
                        } else {
                            onPrecoSelecionado(faixa)
                        }
                    }
                )

                Text(
                    when (faixa) {
                        "ATE_200" -> "Até R$200"
                        "200_500" -> "R$200 - R$500"
                        "500_1000" -> "R$500 - R$1000"
                        else -> "Acima de R$1000"
                    }
                )
            }
        }
    }
}