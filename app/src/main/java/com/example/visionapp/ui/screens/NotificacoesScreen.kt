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
import com.example.visionapp.model.Notificacao

@Composable
fun NotificacoesScreen() {

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

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
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