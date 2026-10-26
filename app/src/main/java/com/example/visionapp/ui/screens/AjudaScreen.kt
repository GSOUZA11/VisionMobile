package com.example.visionapp.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Help
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.visionapp.model.FAQItem
import com.example.visionapp.navigation.Routes
import com.example.visionapp.ui.components.HomeBottomBar

@Composable
fun AjudaScreen(
    navController: NavController
) {

    val perguntas = listOf(

        FAQItem(
            "Como acompanhar meu pedido?",
            "Você pode acompanhar seu pedido através do histórico de compras."
        ),

        FAQItem(
            "Qual é o prazo de entrega?",
            "O prazo varia conforme sua região e transportadora."
        ),

        FAQItem(
            "Como solicitar uma troca?",
            "Acesse Fale Conosco ou entre em contato com o suporte."
        ),

        FAQItem(
            "Qual é o período de garantia?",
            "Todos os produtos possuem garantia de 12 meses."
        ),

        FAQItem(
            "Vocês trabalham com lentes progressivas?",
            "Sim, trabalhamos com lentes progressivas de alta qualidade."
        ),

        FAQItem(
            "Posso cancelar um pedido?",
            "Sim, antes da expedição do produto."
        ),

        FAQItem(
            "Quais formas de pagamento são aceitas?",
            "Pix, cartão de crédito e débito."
        )

    )

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
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            item {

                Icon(
                    imageVector = Icons.Default.Help,
                    contentDescription = null
                )

                Spacer(
                    modifier = Modifier.height(8.dp)
                )

                Text(
                    text = "Central de Ajuda",
                    style = MaterialTheme.typography.headlineMedium
                )

                Text(
                    text = "Suporte para dúvidas frequentes."
                )

                Spacer(
                    modifier = Modifier.height(12.dp)
                )
            }

            items(perguntas) { item ->

                FAQCard(item)

            }
        }
    }
}

@Composable
fun FAQCard(
    faq: FAQItem
) {

    var expandido by remember {
        mutableStateOf(false)
    }

    Card(
        modifier = Modifier.fillMaxWidth()
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    expandido = !expandido
                }
                .padding(16.dp)
        ) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement =
                    Arrangement.SpaceBetween,
                verticalAlignment =
                    Alignment.CenterVertically
            ) {

                Text(
                    text = faq.pergunta
                )

                Icon(
                    imageVector =
                        if (expandido)
                            Icons.Default.KeyboardArrowUp
                        else
                            Icons.Default.KeyboardArrowDown,
                    contentDescription = null
                )
            }

            if (expandido) {

                Spacer(
                    modifier = Modifier.height(8.dp)
                )

                Text(
                    text = faq.resposta
                )
            }
        }
    }
}