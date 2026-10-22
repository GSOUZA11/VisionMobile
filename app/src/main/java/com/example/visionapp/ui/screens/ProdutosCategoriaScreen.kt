package com.example.visionapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.visionapp.ui.components.FiltroBar
import com.example.visionapp.ui.components.ProdutoMiniCard
import com.example.visionapp.viewmodel.OculosViewModel

@Composable
fun ProdutosCategoriaScreen(
    navController: NavController,
    categoria: String
) {

    val oculosViewModel: OculosViewModel = viewModel()

    var pesquisa by remember {
        mutableStateOf("")
    }

    val produtos = oculosViewModel.listaOculos.value
        .filter {
            it.categoria.equals(
                categoria,
                ignoreCase = true
            )
        }
        .filter {
            it.nome.contains(
                pesquisa,
                ignoreCase = true
            )
        }

    Scaffold { padding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
        ) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
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

                IconButton(
                    onClick = {}
                ) {
                    Icon(
                        Icons.Default.Notifications,
                        contentDescription = null
                    )
                }
            }

            Spacer(
                modifier = Modifier.height(12.dp)
            )

            Text(
                text = "Óculos $categoria",
                style = MaterialTheme.typography.headlineMedium
            )

            Text(
                text = "${produtos.size} produtos encontrados"
            )

            Spacer(
                modifier = Modifier.height(12.dp)
            )

            OutlinedTextField(
                value = pesquisa,
                onValueChange = {
                    pesquisa = it
                },
                modifier = Modifier.fillMaxWidth(),
                leadingIcon = {
                    Icon(
                        Icons.Default.Search,
                        contentDescription = null
                    )
                },
                placeholder = {
                    Text("Buscar produto")
                }
            )

            Spacer(
                modifier = Modifier.height(12.dp)
            )

            FiltroBar(
                onFiltroClick = {
                    // Próxima etapa
                },
                onOrdenarClick = {
                    // Próxima etapa
                }
            )

            Spacer(
                modifier = Modifier.height(16.dp)
            )

            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {

                items(produtos) { produto ->

                    ProdutoMiniCard(
                        nome = produto.nome,
                        preco = produto.preco,
                        imagem = produto.imagem
                    )
                }
            }
        }
    }
}