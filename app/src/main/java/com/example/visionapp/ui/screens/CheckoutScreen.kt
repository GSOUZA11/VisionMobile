package com.example.visionapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.visionapp.navigation.Routes
import com.example.visionapp.viewmodel.CarrinhoViewModel

@Composable
fun CheckoutScreen(
    navController: NavController
) {

    val carrinhoViewModel =
        CarrinhoViewModel.getInstance()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text = "Checkout",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        Text(
            text = "Itens: ${carrinhoViewModel.totalItens()}"
        )

        Text(
            text = "Total: R$ ${carrinhoViewModel.valorTotal()}"
        )

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        Button(
            onClick = {
                navController.navigate(
                    Routes.PAGAMENTO
                )
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Ir para Pagamento")
        }
    }
}