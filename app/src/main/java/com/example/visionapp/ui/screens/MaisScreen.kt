package com.example.visionapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.visionapp.navigation.Routes
import com.example.visionapp.utils.TokenManager

@Composable
fun MaisScreen(
    navController: NavController
) {

    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text = "Mais+",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        Button(
            onClick = {

                TokenManager(context)
                    .clearToken()

                navController.navigate(
                    Routes.LOGIN
                ) {
                    navController.navigate(
                        Routes.LOGIN
                    ) {
                        popUpTo(Routes.HOME) {
                            inclusive = true
                        }
                    }
                }
            }
        ) {

            Text("Sair")
        }
    }
}