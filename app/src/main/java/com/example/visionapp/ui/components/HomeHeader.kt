package com.example.visionapp.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun HomeHeader(
    quantidadeProdutos: Int
) {

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Column {

            Text(
                text = "Olá, Vision!",
                color = Color.Gray
            )

            Text(
                text = "Bem vindo de volta!",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "Produtos encontrados: $quantidadeProdutos"
            )
        }

        Row {

            IconButton(
                onClick = {}
            ) {
                Icon(
                    Icons.Default.Notifications,
                    contentDescription = null
                )
            }

            IconButton(
                onClick = {}
            ) {
                Icon(
                    Icons.Default.Person,
                    contentDescription = null
                )
            }
        }
    }
}