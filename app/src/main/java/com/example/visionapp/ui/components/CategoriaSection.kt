package com.example.visionapp.ui.components

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.visionapp.model.Oculos

@Composable
fun CategoriaSection(
    categoria: String,
    produtos: List<Oculos>,
    onVerMais: () -> Unit = {},
    onProdutoClick: (Oculos) -> Unit = {}
) {

    Column {

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            val nomeCategoria = when (categoria.lowercase()) {

                "sol" -> "Óculos de Sol"

                "grau" -> "Óculos de Grau"

                "esportivo" -> "Óculos Esportivos"

                "infantil" -> "Óculos Infantis"

                else -> categoria
            }
            Text(
                text = nomeCategoria,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "Ver mais",
                color = Color(0xFF149AF5)
            )
        }

        Spacer(
            modifier = Modifier.height(12.dp)
        )

        Row(
            modifier = Modifier.horizontalScroll(
                rememberScrollState()
            )
        ) {

            produtos.take(5).forEach { produto ->

                ProdutoMiniCard(
                    nome = produto.nome,
                    preco = produto.preco,
                    onSaibaMais = {
                        onProdutoClick(produto)
                    }
                )

                Spacer(
                    modifier = Modifier.width(8.dp)
                )
            }
        }
    }
}