package com.example.visionapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.visionapp.ui.screens.CadastroScreen
import com.example.visionapp.ui.screens.CarrinhoScreen
import com.example.visionapp.ui.screens.CategoriaScreen
import com.example.visionapp.ui.screens.DetalhesProdutoScreen
import com.example.visionapp.ui.screens.EsqueceuSenhaScreen
import com.example.visionapp.ui.screens.HomeScreen
import com.example.visionapp.ui.screens.LoginScreen
import com.example.visionapp.ui.screens.MaisScreen
import com.example.visionapp.ui.screens.SplashScreen

@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.SPLASH
    ) {

        composable(Routes.SPLASH) {
            SplashScreen(navController)
        }

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

        composable("detalhes_produto/{id}") { backStackEntry ->

            val id = backStackEntry.arguments
                ?.getString("id")
                ?.toIntOrNull() ?: 0

            DetalhesProdutoScreen(
                id = id,
                navController = navController
            )
        }

        composable(Routes.CATEGORIA) {
            CategoriaScreen(navController)
        }

        composable(Routes.CARRINHO) {
            CarrinhoScreen(navController)
        }

        composable(Routes.MAIS) {
            MaisScreen(navController)
        }
    }
}