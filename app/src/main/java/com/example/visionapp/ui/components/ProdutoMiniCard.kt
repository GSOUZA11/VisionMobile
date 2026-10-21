package com.example.visionapp.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun ProdutoMiniCard(
    nome: String,
    preco: Double,
    onSaibaMais: () -> Unit = {}
) {

    Card(
        modifier = Modifier
            .width(170.dp)
            .padding(4.dp),
        shape = RoundedCornerShape(16.dp)
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // Imagem virá depois

            Spacer(
                modifier = Modifier.height(12.dp)
            )

            Text(
                text = nome,
                textAlign = TextAlign.Center
            )

            Spacer(
                modifier = Modifier.height(8.dp)
            )

            Text(
                text = "R$ %.2f".format(preco)
            )

            Spacer(
                modifier = Modifier.height(12.dp)
            )

            Button(
                onClick = onSaibaMais,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFE67600)
                )
            ) {

                Text("Saiba Mais")
            }
        }
    }
}