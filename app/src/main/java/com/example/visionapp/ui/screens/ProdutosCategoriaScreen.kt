package com.example.visionapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.visionapp.navigation.Routes
import com.example.visionapp.ui.components.FiltroBar
import com.example.visionapp.ui.components.FiltroBottomSheet
import com.example.visionapp.ui.components.HomeBottomBar
import com.example.visionapp.ui.components.OrdenacaoBottomSheet
import com.example.visionapp.ui.components.ProdutoMiniCard
import com.example.visionapp.viewmodel.OculosViewModel
import kotlin.text.contains
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProdutosCategoriaScreen(
    navController: NavController,
    categoria: String
) {

    val oculosViewModel: OculosViewModel = viewModel()
    LaunchedEffect(Unit) {
        oculosViewModel.carregarOculos()
    }

    var mostrarFiltro by remember {
        mutableStateOf(false)
    }

    var mostrarOrdenacao by remember {
        mutableStateOf(false)
    }


    val produtos = oculosViewModel.listaOculos.value
        .filter {
            it.categoria.equals(
                categoria,
                ignoreCase = true
            )
        }
        .filter {
            oculosViewModel.pesquisa.value.isBlank() ||
                    it.nome.contains(
                        oculosViewModel.pesquisa.value,
                        ignoreCase = true
                    )
        }
        .filter {

            oculosViewModel.corSelecionada.value == null ||

                    it.cor.equals(
                        oculosViewModel.corSelecionada.value,
                        ignoreCase = true
                    )
        }
        .filter {

            when (oculosViewModel.precoSelecionado.value) {

                "ATE_200" ->
                    it.preco <= 200.0

                "200_500" ->
                    it.preco in 200.0..500.0

                "500_1000" ->
                    it.preco in 500.0..1000.0

                "ACIMA_1000" ->
                    it.preco > 1000.0

                else -> true
            }
        }

        .let { lista ->

            when (oculosViewModel.ordenacaoSelecionada.value) {

                "MENOR_PRECO" ->
                    lista.sortedBy { it.preco }

                "MAIOR_PRECO" ->
                    lista.sortedByDescending { it.preco }

                "AZ" ->
                    lista.sortedBy { it.nome }

                "ZA" ->
                    lista.sortedByDescending { it.nome }

                else -> lista
            }
        }

    if (mostrarFiltro) {

        ModalBottomSheet(
            onDismissRequest = {
                mostrarFiltro = false
            }
        ) {

            FiltroBottomSheet(
                corSelecionada =
                    oculosViewModel.corSelecionada.value,

                precoSelecionado =
                    oculosViewModel.precoSelecionado.value,

                onCorSelecionada = {
                    oculosViewModel.atualizarCor(it)
                },

                onPrecoSelecionado = {
                    oculosViewModel.atualizarPreco(it)
                }
            )
        }
    }
    if (mostrarOrdenacao) {

        ModalBottomSheet(
            onDismissRequest = {
                mostrarOrdenacao = false
            }
        ) {

            OrdenacaoBottomSheet(
                ordenacaoSelecionada =
                    oculosViewModel.ordenacaoSelecionada.value,

                onOrdenacaoSelecionada = {
                    oculosViewModel.atualizarOrdenacao(it)
                }
            )
        }
    }

    Scaffold(

        bottomBar = {
            HomeBottomBar(
                currentRoute = Routes.CATEGORIA,
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
                        Icons.AutoMirrored.Filled.ArrowBack,
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
                value = oculosViewModel.pesquisa.value,
                onValueChange = {
                    oculosViewModel.atualizarPesquisa(it)
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
                    mostrarFiltro = true
                },
                onOrdenarClick = {
                    mostrarOrdenacao = true
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
                        id = produto.id,
                        nome = produto.nome,
                        preco = produto.preco,
                        imagem = produto.imagem,
                        navController = navController
                    )
                }
            }
        }
    }
}