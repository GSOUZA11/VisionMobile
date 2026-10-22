package com.example.visionapp.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun HomeHeader(
    nomeUsuario: String,
    onNotificacaoClick: () -> Unit
) {

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Top
    ) {

        Column {

            Text(
                text = "Olá, $nomeUsuario 👋",
                style = MaterialTheme.typography.headlineSmall
            )

            Text(
                text = "Encontre seus óculos ideais"
            )
        }

        IconButton(
            onClick = onNotificacaoClick
        ) {

            Icon(
                Icons.Default.Notifications,
                contentDescription = null
            )
        }
    }
}