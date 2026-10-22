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
import com.example.visionapp.model.Pedido

@Composable
fun MinhasComprasScreen() {

    val pedidos = listOf(
        Pedido(
            id = 1,
            data = "22/10/2026",
            total = 499.90,
            status = "Entregue"
        ),
        Pedido(
            id = 2,
            data = "20/10/2026",
            total = 299.90,
            status = "Em transporte"
        )
    )

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
                        text = "Data: ${pedido.data}"
                    )

                    Text(
                        text = "Status: ${pedido.status}"
                    )

                    Text(
                        text = "Total: R$ ${pedido.total}"
                    )
                }
            }
        }
    }
}