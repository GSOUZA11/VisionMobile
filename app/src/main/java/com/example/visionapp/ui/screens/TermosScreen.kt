package com.example.visionapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Description
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.visionapp.navigation.Routes
import com.example.visionapp.ui.components.HomeBottomBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TermosScreen(
    navController: NavController
) {

    val termos = """
Ao utilizar o VisionApp, o usuário concorda com os termos descritos abaixo.

1. Uso da Plataforma
O aplicativo tem como finalidade auxiliar os usuários na visualização e compra de óculos.

2. Cadastro
O usuário é responsável pela veracidade das informações fornecidas durante o cadastro.

3. Privacidade
Os dados cadastrados serão utilizados apenas para fins relacionados ao funcionamento do aplicativo.

4. Produtos
As informações dos produtos estão sujeitas à atualização e disponibilidade em estoque.

5. Responsabilidades
O uso inadequado da plataforma poderá resultar em restrições de acesso.

6. Alterações
Estes termos podem ser atualizados sem aviso prévio.
    """.trimIndent()

    Scaffold(
        bottomBar = {
            HomeBottomBar(
                currentRoute = Routes.CATEGORIA,
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

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        IconButton(
                            onClick = {
                                navController.popBackStack()
                            }
                        ) {
                            Icon(
                                Icons.Default.ArrowBack,
                                contentDescription = null
                            )
                        }

                        Text(
                            text = "Categorias",
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold
                        )

                        IconButton(
                            onClick = {}
                        ) {
                            Icon(
                                Icons.Default.Notifications,
                                contentDescription = null
                            )
                        }
                    }

                    IconButton(
                        onClick = {
                            navController.popBackStack()
                        }
                    ) {

                        Icon(
                            Icons.Default.ArrowBack,
                            contentDescription = "Voltar"
                        )
                    }

                    IconButton(
                        onClick = { }
                    ) {

                        Icon(
                            Icons.Default.Notifications,
                            contentDescription = "Notificações"
                        )
                    }
                }

                Spacer(
                    modifier = Modifier.height(8.dp)
                )



                    Icon(
                        imageVector = Icons.Default.Description,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier
                            .size(48.dp)
                            .padding(top = 8.dp)
                    )

                    Spacer(
                        modifier = Modifier.height(16.dp)
                    )

                    Text(
                        text = "Leia atentamente antes de utilizar o aplicativo",
                        style = MaterialTheme.typography.headlineSmall
                    )

                    Spacer(
                        modifier = Modifier.height(16.dp)
                    )

                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(20.dp),
                        elevation = CardDefaults.cardElevation(
                            defaultElevation = 4.dp
                        )
                    ) {

                        Column(
                            modifier = Modifier.padding(20.dp)
                        ) {

                            Text(
                                text = "Última atualização",
                                color = MaterialTheme.colorScheme.primary
                            )

                            Spacer(
                                modifier = Modifier.height(4.dp)
                            )

                            Text(
                                text = "Outubro de 2026",
                                fontWeight = FontWeight.Bold
                            )

                            Spacer(
                                modifier = Modifier.height(16.dp)
                            )

                            Text(
                                text = termos,
                                lineHeight = 24.sp
                            )
                        }
                    }

                    Spacer(
                        modifier = Modifier.height(24.dp)
                    )

            }
        }
    }

}