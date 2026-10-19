package com.example.visionapp.ui

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.example.visionapp.navigation.Routes
import com.example.visionapp.utils.TokenManager

@Composable
fun SplashScreen(
    navController: NavController
) {

    val context = LocalContext.current

    LaunchedEffect(Unit) {

        val token =
            TokenManager(context)
                .getToken()

        if (!token.isNullOrEmpty()) {

            navController.navigate(
                Routes.HOME
            ) {
                popUpTo(0)
            }

        } else {

            navController.navigate(
                Routes.LOGIN
            ) {
                popUpTo(0)
            }

        }
    }

    Text("Carregando...")

}