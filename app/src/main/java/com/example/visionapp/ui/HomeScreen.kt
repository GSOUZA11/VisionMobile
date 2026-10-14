package com.example.visionapp.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun HomeScreen(
    navController: NavController
) {

    Scaffold(

        bottomBar = {

            NavigationBar(
                containerColor = Color(0xFF303030)
            ) {

                NavigationBarItem(
                    selected = true,
                    onClick = {},
                    icon = {
                        Icon(Icons.Default.Home, contentDescription = null)
                    },
                    label = {
                        Text("Home")
                    }
                )

                NavigationBarItem(
                    selected = false,
                    onClick = {},
                    icon = {
                        Icon(Icons.Default.Favorite, contentDescription = null)
                    },
                    label = {
                        Text("Favorito")
                    }
                )

                NavigationBarItem(
                    selected = false,
                    onClick = {},
                    icon = {
                        Icon(Icons.Default.ShoppingCart, contentDescription = null)
                    },
                    label = {
                        Text("Carrinho")
                    }
                )

                NavigationBarItem(
                    selected = false,
                    onClick = {},
                    icon = {
                        Icon(Icons.Default.Person, contentDescription = null)
                    },
                    label = {
                        Text("Pedidos")
                    }
                )
            }
        }

    ) { padding ->

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
        ) {

            item {

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Column {

                        Text(
                            text = "Olá, Vision!",
                            color = Color.Gray
                        )

                        Text(
                            text = "Bem vindo de volta!",
                            style = MaterialTheme.typography.headlineMedium,
                            fontWeight = FontWeight.Bold
                        )
                    }

                    Row {

                        IconButton(onClick = {}) {
                            Icon(
                                Icons.Default.Notifications,
                                contentDescription = null
                            )
                        }

                        IconButton(onClick = {}) {
                            Icon(
                                Icons.Default.Person,
                                contentDescription = null
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    modifier = Modifier.fillMaxWidth(),
                    leadingIcon = {
                        Icon(
                            Icons.Default.Search,
                            contentDescription = null
                        )
                    },
                    placeholder = {
                        Text("Pesquisar")
                    }
                )

                Spacer(modifier = Modifier.height(20.dp))

                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(20.dp)
                ) {

                    Column(
                        modifier = Modifier.padding(20.dp)
                    ) {

                        Text(
                            text = "ÓCULOS QUE COMBINAM COM SEU ESTILO",
                            color = Color(0xFF149AF5),
                            fontWeight = FontWeight.Bold
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = "Design moderno, proteção total."
                        )

                        Spacer(modifier = Modifier.height(12.dp))

                        Button(
                            onClick = {},
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFFE67600)
                            )
                        ) {
                            Text("Coleção Completa")
                        }
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                Text(
                    text = "Categorias",
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {

                    CategoriaCard("Fashion")
                    CategoriaCard("Fashion")
                    CategoriaCard("Clássico")
                }

                Spacer(modifier = Modifier.height(24.dp))

                Text(
                    text = "Ofertas Especiais",
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(12.dp))

                ProdutoOferta(
                    nome = "UrbanLine",
                    preco = "R$ 207,92"
                )

                Spacer(modifier = Modifier.height(16.dp))

                ProdutoOferta(
                    nome = "Azul Nautilus",
                    preco = "R$ 743,20"
                )
            }
        }
    }
}

@Composable
fun CategoriaCard(
    nome: String
) {

    Card(
        modifier = Modifier.size(
            width = 110.dp,
            height = 120.dp
        ),
        shape = RoundedCornerShape(16.dp)
    ) {

        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = nome,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun ProdutoOferta(
    nome: String,
    preco: String
) {

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp)
    ) {

        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            Text(
                text = nome,
                fontWeight = FontWeight.Bold
            )

            Spacer(
                modifier = Modifier.height(8.dp)
            )

            Text(
                text = preco,
                color = Color(0xFFE67600),
                fontWeight = FontWeight.Bold
            )
        }
    }
}