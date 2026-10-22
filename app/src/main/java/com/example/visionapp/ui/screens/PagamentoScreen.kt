package com.example.visionapp.ui.screens

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.visionapp.navigation.Routes
import com.example.visionapp.viewmodel.CarrinhoViewModel
import com.example.visionapp.model.PedidoReal
import com.example.visionapp.viewmodel.PedidoViewModel

@Composable
fun PagamentoScreen(
    navController: NavController
) {

    val context = LocalContext.current
    val carrinhoViewModel =
        CarrinhoViewModel.getInstance()
    val pedidoViewModel =
        PedidoViewModel.instance

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text = "Pagamento",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        Button(
            onClick = {

                Toast.makeText(
                    context,
                    "Pagamento via PIX realizado",
                    Toast.LENGTH_SHORT
                ).show()

                pedidoViewModel.adicionarPedido(
                    PedidoReal(
                        id = pedidoViewModel.pedidos.size + 1,
                        total = carrinhoViewModel.valorTotal(),
                        quantidadeItens = carrinhoViewModel.totalItens(),
                        status = "Pago"
                    )
                )

                carrinhoViewModel.limparCarrinho()

                navController.navigate(Routes.HOME)
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Pagar com PIX")
        }

        Spacer(
            modifier = Modifier.height(12.dp)
        )

        Button(
            onClick = {

                Toast.makeText(
                    context,
                    "Pagamento via Cartão realizado",
                    Toast.LENGTH_SHORT
                ).show()

                pedidoViewModel.adicionarPedido(
                    PedidoReal(
                        id = pedidoViewModel.pedidos.size + 1,
                        total = carrinhoViewModel.valorTotal(),
                        quantidadeItens = carrinhoViewModel.totalItens(),
                        status = "Pago"
                    )
                )
                carrinhoViewModel.limparCarrinho()

                navController.navigate(Routes.HOME)
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Pagar com Cartão")
        }

        Spacer(
            modifier = Modifier.height(12.dp)
        )

        Button(
            onClick = {

                Toast.makeText(
                    context,
                    "Boleto gerado com sucesso",
                    Toast.LENGTH_SHORT
                ).show()

                pedidoViewModel.adicionarPedido(
                    PedidoReal(
                        id = pedidoViewModel.pedidos.size + 1,
                        total = carrinhoViewModel.valorTotal(),
                        quantidadeItens = carrinhoViewModel.totalItens(),
                        status = "Pago"
                    )
                )
                carrinhoViewModel.limparCarrinho()

                navController.navigate(Routes.HOME)
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Gerar Boleto")
        }
    }
}