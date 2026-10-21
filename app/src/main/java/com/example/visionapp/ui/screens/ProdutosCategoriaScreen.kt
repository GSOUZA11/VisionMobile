package com.example.visionapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.visionapp.model.Oculos

@Composable
fun ProdutosCategoriaScreen(
    navController: NavController,
    categoria: String,
    produtos: List<Oculos>
) {

    Scaffold {

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .padding(16.dp)
        ) {

            item {

                Text(
                    text = categoria,
                    style = MaterialTheme.typography.headlineMedium
                )

                Spacer(
                    modifier = Modifier.height(16.dp)
                )
            }

            items(produtos) { produto ->

                Text(produto.nome)

                Spacer(
                    modifier = Modifier.height(8.dp)
                )
            }
        }
    }
}