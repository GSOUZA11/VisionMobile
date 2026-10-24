package com.example.visionapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import android.content.Intent
import android.net.Uri
import androidx.compose.ui.platform.LocalContext

@Composable
fun FaleConoscoScreen() {

    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text = "Fale Conosco",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        Card(
            modifier = Modifier.fillMaxWidth(),
            onClick = {

                val intent = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse(
                        "https://wa.me/5511999999999"
                    )
                )

                context.startActivity(intent)
            }
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {

                Text("📞 WhatsApp")

                Text("(11) 99999-9999")
            }
        }

        Spacer(
            modifier = Modifier.height(12.dp)
        )

        Card(
            modifier = Modifier.fillMaxWidth(),
            onClick = {

                val intent = Intent(
                    Intent.ACTION_SENDTO
                ).apply {

                    data = Uri.parse(
                        "mailto:suporte@vision.com"
                    )
                }

                context.startActivity(intent)
            }
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {

                Text("✉️ E-mail")

                Text("suporte@vision.com")
            }
        }


        Spacer(
            modifier = Modifier.height(12.dp)
        )

        Card(
            modifier = Modifier.fillMaxWidth(),
            onClick = {

                val intent = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse(
                        "https://www.instagram.com/accounts/login/"
                    )
                )

                context.startActivity(intent)
            }
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {

                Text("📸 Instagram")

                Text("Entrar no Instagram")
            }
        }

    }
}