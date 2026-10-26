package com.example.visionapp.ui.screens

import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.visionapp.viewmodel.OculosViewModel
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.visionapp.navigation.Routes
import com.example.visionapp.ui.components.HomeBanner
import com.example.visionapp.ui.components.HomeHeader
import com.example.visionapp.ui.components.HomeBottomBar
import com.example.visionapp.ui.components.ProdutoMiniCard
import androidx.compose.ui.platform.LocalContext
import com.example.visionapp.utils.AddressManager
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import coil.compose.AsyncImage
import com.example.visionapp.utils.ProfileImageManager


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavController,
    oculosViewModel: OculosViewModel = viewModel()
) {


    val produtos = oculosViewModel.listaOculos.value

    val context = LocalContext.current

    val imageManager =
        ProfileImageManager(context)

    val imageUri =
        imageManager.obterImagem()

    val enderecoSalvo =
        AddressManager(context)
            .obterEndereco()


    var busca by remember {
        mutableStateOf("")
    }

    val produtosFiltrados = produtos.filter {

        it.nome.contains(
            busca,
            ignoreCase = true
        ) ||

                it.categoria.contains(
                    busca,
                    ignoreCase = true
                )

    }



    LaunchedEffect(Unit) {
        oculosViewModel.carregarOculos()
    }
    Scaffold(

        bottomBar = {
            HomeBottomBar(
                currentRoute = Routes.HOME,
                navController = navController
            )
        }

    ) { padding ->

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(horizontal = 16.dp),

            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            item {

                if (imageUri.isNotBlank()) {

                    AsyncImage(
                        model = java.io.File(imageUri),
                        contentDescription = null,
                        modifier = Modifier
                            .size(70.dp)
                            .clip(CircleShape),
                        contentScale = ContentScale.Crop
                    )

                    Spacer(
                        modifier = Modifier.height(8.dp)
                    )
                }

                HomeHeader(
                    nomeUsuario = "Usuario",
                    onNotificacaoClick = {
                        navController.navigate(
                            Routes.NOTIFICACOES
                        )
                    }
                )
            }

            item {

                OutlinedTextField(
                    value = busca,
                    onValueChange = {
                        busca = it
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp),
                    shape = RoundedCornerShape(16.dp),

                    leadingIcon = {
                        Icon(
                            Icons.Default.Search,
                            contentDescription = null
                        )
                    },

                    placeholder = {
                        Text("Buscar óculos...")
                    },

                    singleLine = true
                )
            }

            item {

                Card(
                    modifier = Modifier
                        .fillMaxWidth(),
                    onClick = {
                        navController.navigate(
                            Routes.ENDERECO
                        )
                    },
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surfaceVariant
                    ),
                    shape = RoundedCornerShape(16.dp)
                ) {

                    Text(
                        text =
                            if (enderecoSalvo.isNotBlank()) {
                                "📍 $enderecoSalvo"
                            } else {
                                "📍 Adicione um endereço de entrega"
                            },
                        modifier = Modifier.padding(16.dp)
                    )

                }
            }

            item {

                HomeBanner(
                    onDescubraClick = {
                        navController.navigate(
                            Routes.CATEGORIA
                        )

                    }

                )
                Spacer(
                    modifier = Modifier.height(8.dp)
                )
            }

            item {

                Text(
                    text = "Categorias",
                    style = MaterialTheme.typography.headlineMedium

                )
            }

            item {

                LazyRow(

                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {

                    item {
                        AssistChip(
                            onClick = {
                                navController.navigate(Routes.CATEGORIA)
                            },
                            label = {
                                Text("Sol")
                            }
                        )
                    }

                    item {
                        AssistChip(
                            onClick = {
                                navController.navigate(Routes.CATEGORIA)
                            },
                            label = {
                                Text("Grau")
                            }
                        )
                    }

                    item {
                        AssistChip(
                            onClick = {
                                navController.navigate(Routes.CATEGORIA)
                            },
                            label = {
                                Text("Clássico")
                            }
                        )
                    }

                    item {
                        AssistChip(
                            onClick = {
                                navController.navigate(Routes.CATEGORIA)
                            },
                            label = {
                                Text("Vintage")
                            }
                        )
                    }

                    item {
                        AssistChip(
                            onClick = {
                                navController.navigate(Routes.CATEGORIA)
                            },
                            label = {
                                Text("Esportivo")
                            }
                        )
                    }
                }
            }





            item {

                Text(
                    text = "Produtos em Destaque",
                    style = MaterialTheme.typography.headlineMedium
                )
            }

            item {
                if (
                    busca.isNotEmpty() &&
                    produtosFiltrados.isEmpty()
                ) {

                    Text(
                        text = "Nenhum produto encontrado."
                    )
                }
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    contentPadding = PaddingValues(horizontal = 4.dp)
                ) {

                    items(produtosFiltrados.take(10)) { produto ->

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
}


