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
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.visionapp.viewmodel.PerfilViewModel

@Composable
fun EditarPerfilScreen(
    navController: NavController
) {

    val perfilViewModel: PerfilViewModel = viewModel()

    LaunchedEffect(Unit) {
        perfilViewModel.carregarPerfil()
    }

    val usuario = perfilViewModel.usuario.value

    var nome by remember {
        mutableStateOf("")
    }

    var email by remember {
        mutableStateOf("")
    }

    var telefone by remember {
        mutableStateOf("")
    }

    LaunchedEffect(usuario) {

        usuario?.let {

            nome = it.nome
            email = it.email
            telefone = it.telefone
        }
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
            onValueChange = {
                nome = it
            },
            label = {
                Text("Nome")
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(
            modifier = Modifier.height(16.dp)
        )

        OutlinedTextField(
            value = email,
            onValueChange = {
                email = it
            },
            label = {
                Text("E-mail")
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(
            modifier = Modifier.height(16.dp)
        )

        OutlinedTextField(
            value = telefone,
            onValueChange = {
                telefone = it
            },
            label = {
                Text("Telefone")
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        Button(
            enabled =
                nome.isNotBlank() &&
                        email.isNotBlank(),

            onClick = {

                perfilViewModel.atualizarPerfil(
                    nome = nome,
                    email = email,
                    telefone = telefone
                ) {

                    navController.popBackStack()
                }
            },

            modifier = Modifier.fillMaxWidth()
        ) {

            Text("Salvar Alterações")
        }
    }
}