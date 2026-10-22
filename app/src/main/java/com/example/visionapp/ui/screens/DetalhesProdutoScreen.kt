package com.example.visionapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.example.visionapp.viewmodel.OculosViewModel
import android.widget.Toast
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.example.visionapp.viewmodel.CarrinhoViewModel
import com.example.visionapp.navigation.Routes
import com.example.visionapp.viewmodel.FavoritosViewModel

@Composable
fun DetalhesProdutoScreen(
    id: Int,
    navController: NavController
) {

    val oculosViewModel: OculosViewModel = viewModel()
    val context = LocalContext.current
    val carrinhoViewModel = CarrinhoViewModel.getInstance()
    val favoritosViewModel = FavoritosViewModel.instance

    LaunchedEffect(Unit) {
        oculosViewModel.carregarOculos()
    }

    val produto = oculosViewModel.listaOculos.value
        .find { it.id == id }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        item {

            Text(
                text = "Detalhes do Produto",
                style = MaterialTheme.typography.headlineMedium
            )

            Spacer(
                modifier = Modifier.height(16.dp)
            )

            produto?.let {

                AsyncImage(
                    model = "http://10.39.45.29:3000/uploads/${it.imagem}",
                    contentDescription = it.nome,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(250.dp)
                )

                Spacer(
                    modifier = Modifier.height(16.dp)
                )
            }

            Text(
                text = produto?.nome ?: "Carregando...",
                style = MaterialTheme.typography.headlineSmall
            )

            Spacer(
                modifier = Modifier.height(12.dp)
            )

            Text(
                text = "Categoria: ${produto?.categoria ?: ""}"
            )

            Text(
                text = "Cor: ${produto?.cor ?: ""}"
            )

            Text(
                text = "Grau: ${produto?.grau ?: "Não informado"}"
            )

            Text(
                text = "Tamanho: ${produto?.tamanho ?: ""}"
            )

            Spacer(
                modifier = Modifier.height(12.dp)
            )

            Text(
                text = "Descrição:",
                fontWeight = FontWeight.Bold
            )

            Text(
                text = produto?.descricao ?: ""
            )

            Spacer(
                modifier = Modifier.height(12.dp)
            )

            Text(
                text = "Em estoque: ${produto?.estoque ?: 0} unidades",
                color = Color(0xFF1976D2)
            )

            Spacer(
                modifier = Modifier.height(12.dp)
            )

            Text(
                text = "R$ ${produto?.preco ?: ""}",
                color = Color(0xFF2E7D32),
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.headlineSmall
            )

            Spacer(
                modifier = Modifier.height(24.dp)
            )

            Text(
                text = "Itens no carrinho: ${carrinhoViewModel.totalItens()}"
            )

            Spacer(
                modifier = Modifier.height(8.dp)
            )
            Text(
                text = "Valor total: R$ ${carrinhoViewModel.valorTotal()}"
            )

            Spacer(
                modifier = Modifier.height(8.dp)
            )
            Button(
                onClick = {

                    produto?.let {

                        favoritosViewModel.adicionar(it)

                        Toast.makeText(
                            context,
                            "${it.nome} adicionado aos favoritos",
                            Toast.LENGTH_SHORT
                        ).show()

                    }

                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("❤️ Adicionar aos Favoritos")
            }

            Spacer(
                modifier = Modifier.height(12.dp)
            )

            Button(
                onClick = {

                    produto?.let {

                        carrinhoViewModel.adicionarProduto(it)

                        Toast.makeText(
                            context,
                            "${it.nome} adicionado ao carrinho",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Adicionar ao Carrinho")
            }

            Spacer(
                modifier = Modifier.height(12.dp)
            )

            Button(
                onClick = {

                    produto?.let {

                        carrinhoViewModel.adicionarProduto(it)

                        Toast.makeText(
                            context,
                            "Produto adicionado. Abrir carrinho em breve.",
                            Toast.LENGTH_SHORT
                        ).show()

                        navController.navigate(Routes.CARRINHO)
                    }

                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Comprar Agora")
            }

            Spacer(
                modifier = Modifier.height(24.dp)
            )
        }
    }
}