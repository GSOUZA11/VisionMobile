package com.example.visionapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.visionapp.ui.CadastroScreen
import com.example.visionapp.ui.EsqueceuSenhaScreen
import com.example.visionapp.ui.HomeScreen
import com.example.visionapp.ui.LoginScreen

@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.LOGIN
    ) {

        composable(Routes.LOGIN) {
            LoginScreen(navController)
        }

        composable(Routes.CADASTRO) {
            CadastroScreen(navController)
        }
        composable(Routes.ESQUECEU_SENHA) {
            EsqueceuSenhaScreen(navController)
        }
        composable(Routes.HOME) {
            HomeScreen(navController)
        }
    }
}
