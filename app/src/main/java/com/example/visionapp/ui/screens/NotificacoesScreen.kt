package com.example.visionapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.visionapp.model.Notificacao
import androidx.compose.material3.Scaffold
import com.example.visionapp.navigation.Routes
import com.example.visionapp.ui.components.HomeBottomBar

@Composable
fun NotificacoesScreen(
    navController: NavController
) {

    val notificacoes = listOf(

        Notificacao(
            titulo = "Bem-vindo!",
            descricao = "Obrigado por utilizar a Vision."
        ),

        Notificacao(
            titulo = "Compra realizada",
            descricao = "Seu pedido foi registrado com sucesso."
        ),

        Notificacao(
            titulo = "Novos produtos",
            descricao = "Confira os modelos recém adicionados."
        )

    )

    Scaffold(
        bottomBar = {
            HomeBottomBar(
                currentRoute = Routes.MAIS,
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

                Text(
                    text = "Notificações",
                    style = MaterialTheme.typography.headlineMedium
                )

                Spacer(
                    modifier = Modifier.height(16.dp)
                )

            }

            items(notificacoes) { notificacao ->

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 12.dp)
                ) {

                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {

                        Text(
                            text = notificacao.titulo
                        )

                        Spacer(
                            modifier = Modifier.height(4.dp)
                        )

                        Text(
                            text = notificacao.descricao
                        )

                    }

                }

            }

        }

    }
}