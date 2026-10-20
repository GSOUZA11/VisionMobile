package com.example.visionapp.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.items
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
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.visionapp.viewmodel.OculosViewModel
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.ui.platform.LocalContext
import com.example.visionapp.navigation.Routes
import com.example.visionapp.utils.TokenManager
import coil.compose.AsyncImage
import com.example.visionapp.ui.components.CategoriaCard
import com.example.visionapp.ui.components.HomeHeader
import com.example.visionapp.ui.components.HomeBottomBar
import com.example.visionapp.ui.components.SearchBar


@Composable
fun HomeScreen(
    navController: NavController
) {
    val oculosViewModel: OculosViewModel = viewModel()

    val context = LocalContext.current

    LaunchedEffect(Unit) {
        oculosViewModel.carregarOculos()
    }

    Scaffold(

        bottomBar = {
            HomeBottomBar()
        }


    ) { padding ->

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
        ) {

            item {

                HomeHeader(
                    quantidadeProdutos =
                        oculosViewModel.listaOculos.value.size
                )

                Spacer(modifier = Modifier.height(16.dp))

                SearchBar()

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
            }
                items(
                    oculosViewModel.listaOculos.value
                ) { oculos ->

                    ProdutoOferta(
                        nome = oculos.nome,
                        preco = "R$ ${oculos.preco}",
                        categoria = oculos.categoria,
                        cor = oculos.cor,
                        material = oculos.material,
                        imagem = oculos.imagem,
                        onClick = {
                            navController.navigate("detalhes_produto/${oculos.id}")
                        }
                    )

                    Spacer(
                        modifier = Modifier.height(16.dp)
                    )
                }
        }
    }
}



@Composable
fun ProdutoOferta(
    nome: String,
    preco: String,
    categoria: String,
    cor: String,
    material: String?,
    imagem: String,
    onClick: () -> Unit

) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onClick()
            },
        shape = RoundedCornerShape(16.dp)
    ) {


    Column(
            modifier = Modifier.padding(16.dp)
        ) {

            AsyncImage(
                model = "http://10.39.45.29:3000/uploads/$imagem",
                contentDescription = nome,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
            )

            Spacer(
                modifier = Modifier.height(8.dp)
            )

            Text(
                text = nome,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "Categoria: $categoria"
            )

            Text(
                text = "Cor: $cor"
            )

            Text(
                text = "Material: ${material ?: "Não informado"}"
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