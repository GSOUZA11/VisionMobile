package com.example.visionapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Scaffold
import androidx.navigation.NavController
import com.example.visionapp.navigation.Routes
import com.example.visionapp.ui.components.HomeBottomBar

@Composable
fun TermosUsoScreen(
    navController: NavController
) {

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
                text = "Termos de Uso",
                style = MaterialTheme.typography.headlineMedium
            )

            Spacer(
                modifier = Modifier.height(16.dp)
            )

            Text(
                text =
                    "Ao utilizar o Vision Mobile, o usuário concorda com as condições de utilização do aplicativo e com o tratamento dos dados necessários para o funcionamento da plataforma."
            )
        }
    }
}
