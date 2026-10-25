package com.example.visionapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.visionapp.model.PedidoReal
import androidx.compose.ui.graphics.Color
import androidx.compose.runtime.*




@Composable
fun DetalhePedidoScreen(
    pedido: PedidoReal,
    onExcluirPedido: () -> Unit,
    onComprarNovamente: () -> Unit
) {

    var mostrarDialogoExclusao by remember {
        mutableStateOf(false)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text = "Detalhes do Pedido",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        val corStatus = when (pedido.status) {

            "Pago" -> Color(0xFF4CAF50)

            "Em Separação" -> Color(0xFFFFC107)

            "Enviado" -> Color(0xFF2196F3)

            "Entregue" -> Color(0xFF4CAF50)

            else -> Color.Red
        }

        Card(
            modifier = Modifier.fillMaxWidth()
        ) {

            Column(
                modifier = Modifier.padding(16.dp)
            ) {

                Text(
                    text = "Pedido #${pedido.id}",
                    fontWeight = FontWeight.Bold
                )


                Spacer(
                    modifier = Modifier.height(8.dp)
                )

                Text(
                    text = "Status: ${pedido.status}",
                    color = corStatus
                )
                Text(
                    text = "Data: ${pedido.data}"
                )
                Spacer(
                    modifier = Modifier.height(12.dp)
                )

                Text(
                    text = "📍 Endereço de Entrega",
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = pedido.endereco.ifBlank {
                        "Endereço não cadastrado"
                    }
                )

                Spacer(
                    modifier = Modifier.height(12.dp)
                )

                Text(
                    text = "Itens: ${pedido.quantidadeItens}"
                )

                Text(
                    text = "Valor: R$ ${pedido.total}"
                )
            }
            Spacer(
                modifier = Modifier.height(16.dp)
            )

            Button(
                onClick = {
                    mostrarDialogoExclusao = true
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Excluir Pedido")
            }

            Spacer(
                modifier = Modifier.height(8.dp)
            )

            Button(
                onClick = {
                    onComprarNovamente()
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Comprar Novamente")
            }
        }
    }
    if (mostrarDialogoExclusao) {

        AlertDialog(
            onDismissRequest = {
                mostrarDialogoExclusao = false
            },

            title = {
                Text("Excluir Pedido")
            },

            text = {
                Text(
                    "Deseja realmente excluir este pedido?"
                )
            },

            confirmButton = {

                TextButton(
                    onClick = {

                        onExcluirPedido()

                        mostrarDialogoExclusao = false
                    }
                ) {
                    Text("Excluir")
                }
            },

            dismissButton = {

                TextButton(
                    onClick = {
                        mostrarDialogoExclusao = false
                    }
                ) {
                    Text("Cancelar")
                }
            }
        )
    }
}