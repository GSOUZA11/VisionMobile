package com.example.visionapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.visionapp.navigation.Routes
import com.example.visionapp.ui.components.HomeBottomBar
import com.example.visionapp.viewmodel.CarrinhoViewModel

@Composable
fun CarrinhoScreen(
    navController: NavController
) {

    val carrinhoViewModel =
        CarrinhoViewModel.getInstance()

    val produtos =
        carrinhoViewModel.itensCarrinho

    Scaffold(
        bottomBar = {
            HomeBottomBar(
                currentRoute = Routes.CARRINHO,
                navController = navController
            )
        }
    ) { padding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
        ) {

            Text("Carrinho")

            Spacer(
                modifier = Modifier.height(16.dp)
            )

            LazyColumn(
                modifier = Modifier.weight(1f)
            ) {

                items(produtos) { produto ->

                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 8.dp)
                    ) {

                        Column(
                            modifier = Modifier.padding(16.dp)
                        ) {

                            Text(produto.nome)

                            Text(
                                "R$ ${produto.preco}"
                            )

                        }
                    }
                }
            }

            Spacer(
                modifier = Modifier.height(16.dp)
            )

            Text(
                "Itens: ${carrinhoViewModel.totalItens()}"
            )

            Text(
                "Total: R$ ${carrinhoViewModel.valorTotal()}"
            )

            Spacer(
                modifier = Modifier.height(16.dp)
            )

            Button(
                onClick = {
                    navController.navigate(
                        Routes.CHECKOUT
                    )
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Finalizar Compra")
            }
        }
    }
}