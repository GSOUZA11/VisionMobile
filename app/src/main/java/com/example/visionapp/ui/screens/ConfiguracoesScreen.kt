package com.example.visionapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import com.example.visionapp.utils.ThemeManager

@Composable
fun ConfiguracoesScreen(
    onThemeChanged: (Boolean) -> Unit
) {

    var notificacoes by remember {
        mutableStateOf(true)
    }

    val context = LocalContext.current

    val themeManager = ThemeManager(context)

    var temaEscuro by remember {
        mutableStateOf(
            themeManager.obterTemaEscuro()
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text = "Configurações",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        // Notificações
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Text("🔔 Receber notificações")

                Switch(
                    checked = notificacoes,
                    onCheckedChange = {
                        notificacoes = it
                    }
                )
            }
        }

        Spacer(
            modifier = Modifier.height(12.dp)
        )

        // Tema Escuro
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Text("🌙 Tema Escuro")

                Switch(
                    checked = temaEscuro,
                    onCheckedChange = {

                        temaEscuro = it

                        themeManager.salvarTemaEscuro(it)

                        onThemeChanged(it)
                    }
                )
            }
        }

        Spacer(
            modifier = Modifier.height(12.dp)
        )

        // Idioma
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {

                Text(
                    text = "🌎 Idioma",
                    style = MaterialTheme.typography.titleMedium
                )

                Spacer(
                    modifier = Modifier.height(4.dp)
                )

                Text("Português (Brasil)")
            }
        }

        Spacer(
            modifier = Modifier.height(12.dp)
        )

        // Versão
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {

                Text(
                    text = "📱 Versão do Aplicativo",
                    style = MaterialTheme.typography.titleMedium
                )

                Spacer(
                    modifier = Modifier.height(4.dp)
                )

                Text("Vision Mobile 1.0")
            }
        }

        Spacer(
            modifier = Modifier.height(12.dp)
        )

        // Política de Privacidade
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {

                Text(
                    text = "🔒 Política de Privacidade",
                    style = MaterialTheme.typography.titleMedium
                )

                Spacer(
                    modifier = Modifier.height(4.dp)
                )

                Text(
                    text = "Saiba como seus dados são utilizados."
                )
            }
        }

        Spacer(
            modifier = Modifier.height(12.dp)
        )

        // Termos de Uso
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {

                Text(
                    text = "📄 Termos de Uso",
                    style = MaterialTheme.typography.titleMedium
                )

                Spacer(
                    modifier = Modifier.height(4.dp)
                )

                Text(
                    text = "Consulte os termos de utilização do aplicativo."
                )
            }
        }
    }
}
