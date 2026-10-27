package com.example.visionapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.platform.LocalContext
import com.example.visionapp.utils.AddressManager
import androidx.compose.material3.Scaffold
import androidx.navigation.NavController
import com.example.visionapp.navigation.Routes
import com.example.visionapp.ui.components.HomeBottomBar

@Composable
fun EnderecoScreen(
    navController: NavController
) {

    var nome by remember { mutableStateOf("") }
    var cep by remember { mutableStateOf("") }
    var rua by remember { mutableStateOf("") }
    var numero by remember { mutableStateOf("") }
    var complemento by remember { mutableStateOf("") }
    var cidade by remember { mutableStateOf("") }
    var estado by remember { mutableStateOf("") }
    val context = LocalContext.current
    val addressManager = AddressManager(context)
    var salvo by remember {
        mutableStateOf(false)
    }

    Scaffold(
        bottomBar = {
            HomeBottomBar(
                currentRoute = Routes.MAIS,
                navController = navController
            )
        }
    ) { padding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
        ) {

            Text(
                text = "Endereço de Entrega",
                style = MaterialTheme.typography.headlineMedium
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = nome,
                onValueChange = { nome = it },
                label = { Text("Nome") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = cep,
                onValueChange = { cep = it },
                label = { Text("CEP") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = rua,
                onValueChange = { rua = it },
                label = { Text("Rua") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = numero,
                onValueChange = { numero = it },
                label = { Text("Número") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = complemento,
                onValueChange = { complemento = it },
                label = { Text("Complemento") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = cidade,
                onValueChange = { cidade = it },
                label = { Text("Cidade") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = estado,
                onValueChange = { estado = it },
                label = { Text("Estado") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = {

                    val enderecoCompleto =
                        "$rua, $numero - $cidade/$estado"

                    addressManager.salvarEndereco(
                        enderecoCompleto
                    )

                    salvo = true
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Salvar Endereço")
            }
            if (salvo) {

                Spacer(
                    modifier = Modifier.height(8.dp)
                )

                Text(
                    text = "✅ Endereço salvo com sucesso!"
                )
            }
        }
    }
}