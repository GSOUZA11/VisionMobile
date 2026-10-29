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
import androidx.compose.material3.Card
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.example.visionapp.viewmodel.CarrinhoViewModel
import com.example.visionapp.navigation.Routes
import com.example.visionapp.viewmodel.FavoritosViewModel
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.draw.clip

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
                text = produto?.categoria?.uppercase() ?: "",
                color = Color(0xFF5568FE),
                fontWeight = FontWeight.Bold
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {

                Card(
                    modifier = Modifier.weight(1f)
                ) {
                    Column(
                        modifier = Modifier.padding(12.dp)
                    ) {
                        Text("Cor")
                        Text(
                            text = produto?.cor ?: "",
                            fontWeight = FontWeight.Bold
                        )
                    }
                }

                Card(
                    modifier = Modifier.weight(1f)
                ) {
                    Column(
                        modifier = Modifier.padding(12.dp)
                    ) {
                        Text("Tamanho")
                        Text(
                            text = produto?.tamanho ?: "",
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
            Spacer(
                modifier = Modifier.height(8.dp)
            )
            Card(
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.padding(12.dp)
                ) {
                    Text("Grau")

                    Text(
                        text = produto?.grau ?: "Não informado",
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            Spacer(
                modifier = Modifier.height(12.dp)
            )

            Card(
                modifier = Modifier.fillMaxWidth()
            ) {

                Column(
                    modifier = Modifier.padding(16.dp)
                ) {

                    Text(
                        text = "Descrição",
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(
                        modifier = Modifier.height(8.dp)
                    )

                    Text(
                        text = produto?.descricao ?: ""
                    )
                }
            }

            Spacer(
                modifier = Modifier.height(12.dp)
            )

            Card(
                modifier = Modifier.fillMaxWidth()
            ) {

                Text(
                    text = "🟢 ${produto?.estoque ?: 0} unidades disponíveis",
                    modifier = Modifier.padding(16.dp),
                    color = Color(0xFF2E7D32),
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(
                modifier = Modifier.height(12.dp)
            )

            Text(
                text = "R$ ${produto?.preco ?: ""}",
                color = Color(0xFF2E7D32),
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.headlineMedium
            )

            Spacer(
                modifier = Modifier.height(48.dp)
            )

            Card(
                modifier = Modifier.fillMaxWidth()
            ) {

                Column(
                    modifier = Modifier.padding(16.dp)
                ) {

                    Text("✓ Produto disponível")

                    Spacer(
                        modifier = Modifier.height(4.dp)
                    )

                    Text("✓ Compra segura")

                    Spacer(
                        modifier = Modifier.height(4.dp)
                    )

                    Text("✓ Entrega para todo Brasil")
                }
            }

            Spacer(
                modifier = Modifier.height(16.dp)
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