package com.example.visionapp.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.visionapp.navigation.Routes
import com.example.visionapp.ui.components.HomeBottomBar
import com.example.visionapp.viewmodel.OculosViewModel
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.unit.dp
import com.example.visionapp.ui.components.CategoriaSection
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight

@Composable
fun CategoriaScreen(navController: NavController) {

    val oculosViewModel: OculosViewModel = viewModel()

    LaunchedEffect(Unit) {
        oculosViewModel.carregarOculos()
    }

    val categorias =
        oculosViewModel.listaOculos.value
            .groupBy { it.categoria }

    val pesquisa = remember {
        mutableStateOf("")
    }
    Scaffold(
        bottomBar = {
            HomeBottomBar(
                currentRoute = Routes.CATEGORIA,
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

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        IconButton(
                            onClick = {
                                navController.popBackStack()
                            }
                        ) {
                            Icon(
                                Icons.Default.ArrowBack,
                                contentDescription = null
                            )
                        }

                        Text(
                            text = "Categorias",
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold
                        )

                        IconButton(
                            onClick = {}
                        ) {
                            Icon(
                                Icons.Default.Notifications,
                                contentDescription = null
                            )
                        }
                    }

                    IconButton(
                        onClick = {
                            navController.popBackStack()
                        }
                    ) {

                        Icon(
                            Icons.Default.ArrowBack,
                            contentDescription = "Voltar"
                        )
                    }

                    IconButton(
                        onClick = { }
                    ) {

                        Icon(
                            Icons.Default.Notifications,
                            contentDescription = "Notificações"
                        )
                    }
                }

                Spacer(
                    modifier = Modifier.height(8.dp)
                )

                OutlinedTextField(
                    value = pesquisa.value,
                    onValueChange = {
                        pesquisa.value = it
                    },
                    modifier = Modifier.fillMaxWidth(),
                    leadingIcon = {
                        Icon(
                            Icons.Default.Search,
                            contentDescription = null
                        )
                    },
                    placeholder = {
                        Text("Pesquisar óculos")
                    }
                )

                Spacer(
                    modifier = Modifier.height(12.dp)
                )

                Text(
                    text = "📍 Endereço não informado"
                )

                Spacer(
                    modifier = Modifier.height(24.dp)
                )
            }
            categorias.forEach { (categoria, produtos) ->

                item {

                    produtos.forEach {
                        println("IMAGEM: ${it.imagem}")
                    }

                    CategoriaSection(
                        categoria = categoria,
                        produtos = produtos,
                        onVerMais = {

                            navController.navigate(
                                Routes.produtosCategoria(categoria)
                            )

                        }
                    )

                    Spacer(
                        modifier = Modifier.height(24.dp)
                    )
                }
            }
        }
    }
}