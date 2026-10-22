package com.example.visionapp.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.GridView
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
        shape = RoundedCornerShape(36.dp),
        shadowElevation = 12.dp,
        color = Color.Black
    ) {

        NavigationBar(
            containerColor = Color.Transparent
        ) {

            NavigationBarItem(
                selected = currentRoute == Routes.HOME,
                onClick = {
                    navController.navigate(Routes.HOME)
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color.White,
                    selectedTextColor = Color.White,
                    indicatorColor = Color(0xFF149AF5),
                    unselectedIconColor = Color.LightGray,
                    unselectedTextColor = Color.LightGray
                ),
                icon = {
                    Icon(
                        Icons.Default.Home,
                        contentDescription = "Início",
                        modifier = Modifier.size(24.dp)
                    )
                },
                label = {
                    Text(
                        "Início",
                        fontSize = 10.sp
                    )
                }
            )

            NavigationBarItem(
                selected = currentRoute == Routes.CATEGORIA,
                onClick = {
                    navController.navigate(Routes.CATEGORIA)
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color.White,
                    selectedTextColor = Color.White,
                    indicatorColor = Color(0xFF149AF5),
                    unselectedIconColor = Color.LightGray,
                    unselectedTextColor = Color.LightGray
                ),
                icon = {
                    Icon(
                        Icons.Default.GridView,
                        contentDescription = "Categoria",
                        modifier = Modifier.size(24.dp)

                    )
                },
                label = {
                    Text(
                        "Categoria",
                        fontSize = 10.sp
                    )
                }
            )

            NavigationBarItem(
                selected = currentRoute == Routes.CARRINHO,
                onClick = {
                    navController.navigate(Routes.CARRINHO)
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color.White,
                    selectedTextColor = Color.White,
                    indicatorColor = Color(0xFF149AF5),
                    unselectedIconColor = Color.LightGray,
                    unselectedTextColor = Color.LightGray
                ),
                icon = {
                    Icon(
                        Icons.Default.ShoppingCart,
                        contentDescription = "Carrinho",
                        modifier = Modifier.size(24.dp)
                    )
                },
                label = {
                    Text(
                        "Carrinho",
                        fontSize = 10.sp
                    )
                }
            )

            NavigationBarItem(
                selected = currentRoute == Routes.MAIS,
                onClick = {
                    navController.navigate(Routes.MAIS)
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color.White,
                    selectedTextColor = Color.White,
                    indicatorColor = Color(0xFF149AF5),
                    unselectedIconColor = Color.LightGray,
                    unselectedTextColor = Color.LightGray
                ),
                icon = {

                    Icon(
                        Icons.Default.Menu,
                        contentDescription = "Mais+",
                        modifier = Modifier.size(24.dp)
                    )
                },
                label = {
                    Text(
                        "Mais+",
                        fontSize = 10.sp,
                    )
                }
            )
        }
    }
}