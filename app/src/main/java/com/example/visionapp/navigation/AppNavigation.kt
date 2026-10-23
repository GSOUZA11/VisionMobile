package com.example.visionapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.visionapp.ui.screens.CadastroScreen
import com.example.visionapp.ui.screens.CarrinhoScreen
import com.example.visionapp.ui.screens.CategoriaScreen
import com.example.visionapp.ui.screens.DetalhesProdutoScreen
import com.example.visionapp.ui.screens.EditarPerfilScreen
import com.example.visionapp.ui.screens.EsqueceuSenhaScreen
import com.example.visionapp.ui.screens.HomeScreen
import com.example.visionapp.ui.screens.LoginScreen
import com.example.visionapp.ui.screens.MaisScreen
import com.example.visionapp.ui.screens.PerfilScreen
import com.example.visionapp.ui.screens.ProdutosCategoriaScreen
import com.example.visionapp.ui.screens.SplashScreen
import com.example.visionapp.ui.screens.MinhasComprasScreen
import com.example.visionapp.ui.screens.FavoritosScreen
import com.example.visionapp.ui.screens.CheckoutScreen
import com.example.visionapp.ui.screens.PagamentoScreen
import com.example.visionapp.ui.screens.NotificacoesScreen

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

        composable(Routes.PERFIL) {
            PerfilScreen(navController)
        }

        composable(Routes.EDITAR_PERFIL) {
            EditarPerfilScreen(navController)
        }

        composable(Routes.MINHAS_COMPRAS) {
            MinhasComprasScreen()
        }

        composable(Routes.FAVORITOS) {
            FavoritosScreen()
        }

        composable(Routes.CHECKOUT) {
            CheckoutScreen(navController)
        }

        composable(Routes.PAGAMENTO) {
            PagamentoScreen(navController)
        }

        composable(Routes.NOTIFICACOES) {
            NotificacoesScreen()
        }
        composable(
            route = Routes.PRODUTOS_CATEGORIA
        ) { backStackEntry ->

            val categoria =
                backStackEntry.arguments
                    ?.getString("categoria")
                    ?: ""

            ProdutosCategoriaScreen(
                navController = navController,
                categoria = categoria
            )
        }
    }
}
