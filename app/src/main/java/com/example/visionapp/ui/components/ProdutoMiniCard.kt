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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import androidx.compose.ui.layout.ContentScale
import androidx.navigation.NavController
import com.example.visionapp.navigation.Routes
import com.example.visionapp.utils.Constants

@Composable
fun ProdutoMiniCard(
    id: Int,
    nome: String,
    preco: Double,
    imagem: String,
    navController: NavController
){

    Card(
        modifier = Modifier
            .width(200.dp)
            .height(320.dp)
            .padding(4.dp),
        shape = RoundedCornerShape(16.dp)
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AsyncImage(
                model = "${Constants.BASE_URL}uploads/$imagem",
                contentDescription = nome,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
                    .clip(
                        RoundedCornerShape(
                            topStart = 12.dp,
                            topEnd = 12.dp
                        )
                    ),
                contentScale = ContentScale.Crop
            )

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
                onClick = {
                    navController.navigate("detalhes_produto/$id")
                },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFE67600)
                )
            ) {
                Text("Saiba Mais")
            }
        }
    }
}