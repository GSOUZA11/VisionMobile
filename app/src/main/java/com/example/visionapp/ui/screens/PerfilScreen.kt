package com.example.visionapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.visionapp.navigation.Routes
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.runtime.LaunchedEffect
import com.example.visionapp.viewmodel.PerfilViewModel

@Composable
fun PerfilScreen(
    navController: NavController
) {

    val perfilViewModel: PerfilViewModel = viewModel()

    LaunchedEffect(Unit) {
        perfilViewModel.carregarPerfil()
    }

    val usuario = perfilViewModel.usuario.value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text = "Meu Perfil",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        Card(
            modifier = Modifier.fillMaxWidth()
        ) {

            Column(
                modifier = Modifier.padding(16.dp)
            ) {

                Text(
                    text = usuario?.nome ?: "Carregando...",
                    fontWeight = FontWeight.Bold
                )


                Spacer(
                    modifier = Modifier.height(8.dp)
                )

                Text(
                    text = usuario?.email ?: ""
                )

                Text(
                    text = usuario?.telefone ?: ""
                )
            }
        }

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        Button(
            onClick = {
                navController.navigate(Routes.EDITAR_PERFIL)
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Editar Perfil")
        }

        Spacer(
            modifier = Modifier.height(12.dp)
        )

        Button(
            onClick = {
                // Logout futuramente
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Sair da Conta")
        }
    }
}