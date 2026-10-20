package com.example.visionapp.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun HomeBottomBar(
    onHomeClick: () -> Unit = {},
    onFavoritosClick: () -> Unit = {},
    onCarrinhoClick: () -> Unit = {},
    onPedidosClick: () -> Unit = {}
) {

    NavigationBar(
        containerColor = Color(0xFF303030)
    ) {

        NavigationBarItem(
            selected = true,
            onClick = onHomeClick,
            icon = {
                Icon(
                    Icons.Default.Home,
                    contentDescription = null
                )
            },
            label = {
                Text("Home")
            }
        )

        NavigationBarItem(
            selected = false,
            onClick = onFavoritosClick,
            icon = {
                Icon(
                    Icons.Default.Favorite,
                    contentDescription = null
                )
            },
            label = {
                Text("Favoritos")
            }
        )

        NavigationBarItem(
            selected = false,
            onClick = onCarrinhoClick,
            icon = {
                Icon(
                    Icons.Default.ShoppingCart,
                    contentDescription = null
                )
            },
            label = {
                Text("Carrinho")
            }
        )

        NavigationBarItem(
            selected = false,
            onClick = onPedidosClick,
            icon = {
                Icon(
                    Icons.Default.Person,
                    contentDescription = null
                )
            },
            label = {
                Text("Pedidos")
            }
        )
    }
}