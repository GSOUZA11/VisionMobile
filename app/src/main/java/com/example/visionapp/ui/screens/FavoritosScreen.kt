package com.example.visionapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.example.visionapp.viewmodel.FavoritosViewModel
import androidx.compose.material3.Scaffold
import androidx.navigation.NavController
import com.example.visionapp.navigation.Routes
import com.example.visionapp.ui.components.HomeBottomBar

@Composable
fun FavoritosScreen(
    navController: NavController
) {

    val favoritosViewModel = FavoritosViewModel.instance

    Scaffold(
        bottomBar = {
            HomeBottomBar(
                currentRoute = Routes.MAIS,
                navController = navController
            )
        }
    ) { padding ->

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
        ) {

            item {

                Text(
                    text = "Favoritos",
                    style = MaterialTheme.typography.headlineMedium
                )

                Spacer(
                    modifier = Modifier.height(16.dp)
                )
            }

            items(favoritosViewModel.favoritos) { produto ->

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 12.dp)
                ) {

                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {

                        AsyncImage(
                            model = "http://10.39.45.29:3000/uploads/${produto.imagem}",
                            contentDescription = produto.nome,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(180.dp)
                        )

                        Spacer(
                            modifier = Modifier.height(8.dp)
                        )

                        Text(
                            text = produto.nome
                        )

                        Text(
                            text = "R$ ${produto.preco}"
                        )
                        Spacer(
                            modifier = Modifier.height(8.dp)
                        )

                        Button(
                            onClick = {
                                favoritosViewModel.remover(produto)
                            },
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text("❌ Remover dos Favoritos")
                        }

                    }
                }
            }
        }
    }
}