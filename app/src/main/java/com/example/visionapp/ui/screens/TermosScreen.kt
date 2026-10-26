package com.example.visionapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Description
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

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
        topBar = {
            TopAppBar(
                title = {
                    Text("Termos e Condições")
                }
            )
        }
    ) { padding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
                .verticalScroll(rememberScrollState())
        ) {

            Icon(
                imageVector = Icons.Default.Description,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier.size(48.dp)
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "Leia atentamente antes de utilizar o aplicativo",
                style = MaterialTheme.typography.headlineSmall
            )

            Spacer(modifier = Modifier.height(20.dp))

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
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.primary
                    )

                    Spacer(modifier = Modifier.height(4.dp))

                    Text(
                        text = "Outubro de 2026",
                        style = MaterialTheme.typography.titleMedium
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    Text(
                        text = termos,
                        style = MaterialTheme.typography.bodyLarge,
                        lineHeight = 24.sp
                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}