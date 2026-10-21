package com.example.visionapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun EditarPerfilScreen(
    navController: NavController
) {

    var nome by remember {
        mutableStateOf("Gabriel Araujo Souza")
    }

    var email by remember {
        mutableStateOf("gabriel@email.com")
    }

    var telefone by remember {
        mutableStateOf("(11) 99999-9999")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text = "Editar Perfil",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        OutlinedTextField(
            value = nome,
            onValueChange = { nome = it },
            label = { Text("Nome") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(
            modifier = Modifier.height(16.dp)
        )

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("E-mail") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(
            modifier = Modifier.height(16.dp)
        )

        OutlinedTextField(
            value = telefone,
            onValueChange = { telefone = it },
            label = { Text("Telefone") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        Button(
            onClick = {
                navController.popBackStack()
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Salvar Alterações")
        }
    }
}