package com.example.visionapp.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.visionapp.navigation.Routes
import com.example.visionapp.ui.components.HomeBottomBar


@Composable
fun CarrinhoScreen(
    navController: NavController
) {

    Scaffold(
        bottomBar = {
            HomeBottomBar(
                currentRoute = Routes.CARRINHO,
                navController = navController
            )
        }
    ) { padding ->

        Box(
            modifier = Modifier.padding(padding)
        ) {
            Text("Carrinho")
        }
    }
}