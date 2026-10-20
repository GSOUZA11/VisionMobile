package com.example.visionapp.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.GridView
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.visionapp.navigation.Routes

@Composable
fun HomeBottomBar(
    currentRoute: String,
    navController: NavController
) {

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = 16.dp,
                vertical = 12.dp
            )
            .navigationBarsPadding(),
        shape = RoundedCornerShape(24.dp),
        shadowElevation = 12.dp,
        color = Color(0xFF303030)
    ) {

        NavigationBar(
            containerColor = Color.Transparent
        ) {

            NavigationBarItem(
                selected = currentRoute == Routes.HOME,
                onClick = {
                    navController.navigate(Routes.HOME)
                },
                icon = {
                    Icon(
                        Icons.Default.Home,
                        contentDescription = "Início"
                    )
                },
                label = {
                    Text("Início")
                }
            )

            NavigationBarItem(
                selected = currentRoute == Routes.CATEGORIA,
                onClick = {
                    navController.navigate(Routes.CATEGORIA)
                },
                icon = {
                    Icon(
                        Icons.Default.GridView,
                        contentDescription = "Categoria"
                    )
                },
                label = {
                    Text("Categoria")
                }
            )

            NavigationBarItem(
                selected = currentRoute == Routes.CARRINHO,
                onClick = {
                    navController.navigate(Routes.CARRINHO)
                },
                icon = {
                    Icon(
                        Icons.Default.ShoppingCart,
                        contentDescription = "Carrinho"
                    )
                },
                label = {
                    Text("Carrinho")
                }
            )

            NavigationBarItem(
                selected = currentRoute == Routes.MAIS,
                onClick = {
                    navController.navigate(Routes.MAIS)
                },
                icon = {
                    Icon(
                        Icons.Default.Menu,
                        contentDescription = "Mais"
                    )
                },
                label = {
                    Text("Mais+")
                }
            )
        }
    }
}