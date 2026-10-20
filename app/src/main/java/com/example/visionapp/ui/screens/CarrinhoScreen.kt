package com.example.visionapp.ui.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.visionapp.navigation.Routes
import com.example.visionapp.ui.components.HomeBottomBar


@Composable
fun CarrinhoScreen(navController: NavController) {
    HomeBottomBar(
        currentRoute = Routes.CATEGORIA,
        navController = navController
    )
}