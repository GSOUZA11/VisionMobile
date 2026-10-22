package com.example.visionapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.visionapp.viewmodel.PedidoViewModel

@Composable
fun MinhasComprasScreen() {

    val pedidoViewModel =
        PedidoViewModel.instance

    val pedidos =
        pedidoViewModel.pedidos

    if (pedidos.isEmpty()) {

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center
        ) {

            Text(
                text = "Nenhuma compra realizada ainda."
            )

        }

        return
    }
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        item {

            Text(
                text = "Minhas Compras",
                style = MaterialTheme.typography.headlineMedium
            )

            Spacer(
                modifier = Modifier.height(16.dp)
            )
        }

        items(pedidos) { pedido ->

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 12.dp)
            ) {

                Column(
                    modifier = Modifier.padding(16.dp)
                ) {

                    Text(
                        text = "Pedido #${pedido.id}",
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        text = "Itens: ${pedido.quantidadeItens}"
                    )
                    Text(
                        text = "Status: ${pedido.status}"
                    )

                    Text(
                        text = "Valor: R$ ${pedido.total}"
                    )
                }
            }
        }
    }
}