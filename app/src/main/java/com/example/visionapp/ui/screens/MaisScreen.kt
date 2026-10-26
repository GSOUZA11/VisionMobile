package com.example.visionapp.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.visionapp.navigation.Routes
import com.example.visionapp.ui.components.HomeBottomBar
import com.example.visionapp.ui.components.MenuItem
import com.example.visionapp.utils.TokenManager
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

@Composable
fun MaisScreen(
    navController: NavController
) {

    val context = LocalContext.current

    var mostrarDialogLogout by remember {
        mutableStateOf(false)
    }

    Scaffold(
        bottomBar = {
            HomeBottomBar(
                currentRoute = Routes.MAIS,
                navController = navController
            )
        }
    ) { padding ->

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
        ) {

            item {

                Text(
                    text = "Guilherme",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            navController.navigate(Routes.PERFIL)
                        },
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Icon(
                            imageVector = Icons.Default.Person,
                            contentDescription = null,
                        )

                        Spacer(
                            modifier = Modifier.width(8.dp)
                        )

                        Text(
                            text = "Meu Perfil",
                        )

                        Icon(
                            imageVector = Icons.Default.ChevronRight,
                            contentDescription = null,
                        )
                    }
                }

                Spacer(
                    modifier = Modifier.height(24.dp)
                )

                HorizontalDivider()

                Spacer(
                    modifier = Modifier.height(16.dp)
                )
            }

            item {
                MenuItem(
                    titulo = "Início",
                    icon = Icons.Default.Home
                )
                MenuItem(
                    titulo = "Fale Conosco",
                    icon = Icons.Default.Email,
                    onClick = {
                        navController.navigate(
                            Routes.FALE_CONOSCO
                        )
                    }
                )
                MenuItem(
                    titulo = "Ajuda",
                    icon = Icons.Default.Info,
                    onClick = {
                        navController.navigate(
                            Routes.AJUDA
                        )
                    }
                )

                Spacer(
                    modifier = Modifier.height(24.dp)
                )

                HorizontalDivider()

                Spacer(
                    modifier = Modifier.height(24.dp)
                )

                Text(
                    text = "Minha Atividade",
                    style = MaterialTheme.typography.titleMedium
                )

                Spacer(
                    modifier = Modifier.height(16.dp)
                )

                MenuItem(
                    titulo = "Minhas Compras",
                    icon = Icons.Default.ShoppingCart,
                    onClick = {
                        navController.navigate(
                            Routes.MINHAS_COMPRAS
                        )
                    }
                )
                MenuItem(
                    titulo = "Notificações",
                    icon = Icons.Default.Notifications,
                    onClick = {
                        navController.navigate(
                            Routes.NOTIFICACOES
                        )
                    }
                )

                MenuItem(
                    titulo = "Favoritos",
                    icon = Icons.Default.Favorite,
                    onClick = {
                        navController.navigate(
                            Routes.FAVORITOS
                        )
                    }
                )

                Spacer(
                    modifier = Modifier.height(24.dp)
                )

                HorizontalDivider()

                Spacer(
                    modifier = Modifier.height(24.dp)
                )

                MenuItem(
                    titulo = "Configuração",
                    icon = Icons.Default.Settings,
                    onClick = {
                        navController.navigate(
                            Routes.CONFIGURACOES
                        )
                    }
                )
                MenuItem(
                    titulo = "Termos e Condições",
                    icon = Icons.Default.Description,
                    onClick = {
                        navController.navigate(
                            Routes.TERMOS
                        )
                    }
                )
                MenuItem(
                    titulo = "Sobre Nós",
                    icon = Icons.Default.Info,
                    onClick = {
                        navController.navigate(
                            Routes.SOBRE_NOS
                        )
                    }
                )

                Spacer(
                    modifier = Modifier.height(32.dp)
                )

                Button(
                    onClick = {
                        mostrarDialogLogout = true
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Sair")
                }
            }
        }
    }
    if (mostrarDialogLogout) {

        AlertDialog(
            onDismissRequest = {
                mostrarDialogLogout = false
            },

            title = {
                Text("Sair")
            },

            text = {
                Text("Deseja realmente sair da conta?")
            },

            confirmButton = {

                TextButton(
                    onClick = {

                        TokenManager(context)
                            .clearToken()

                        navController.navigate(
                            Routes.LOGIN
                        ) {
                            popUpTo(0)
                        }

                        mostrarDialogLogout = false
                    }
                ) {
                    Text("Sair")
                }
            },

            dismissButton = {

                TextButton(
                    onClick = {
                        mostrarDialogLogout = false
                    }
                ) {
                    Text("Cancelar")
                }
            }
        )
    }

}