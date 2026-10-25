package com.example.visionapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.visionapp.navigation.Routes
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.runtime.LaunchedEffect
import com.example.visionapp.viewmodel.PerfilViewModel
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.TextButton
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import coil.compose.AsyncImage
import com.example.visionapp.utils.ProfileImageManager
import androidx.compose.material3.AlertDialog
import com.example.visionapp.R

@Composable
fun PerfilScreen(
    navController: NavController
) {

    val perfilViewModel: PerfilViewModel = viewModel()

    LaunchedEffect(Unit) {
        perfilViewModel.carregarPerfil()
    }

    val usuario = perfilViewModel.usuario.value

    val context = LocalContext.current

    val imageManager =
        ProfileImageManager(context)

    var imageUri by remember {

        mutableStateOf(
            imageManager.obterImagem()
        )
    }
    var mostrarLogout by remember {
        mutableStateOf(false)
    }
    val launcher =
        rememberLauncherForActivityResult(
            contract =
                ActivityResultContracts.GetContent()
        ) { uri ->

            uri?.let {

                val inputStream =
                    context.contentResolver
                        .openInputStream(it)

                val file = java.io.File(
                    context.filesDir,
                    "profile.jpg"
                )

                inputStream?.use { input ->

                    file.outputStream().use { output ->

                        input.copyTo(output)
                    }
                }

                imageUri = file.absolutePath

                imageManager.salvarImagem(
                    file.absolutePath
                )
            }
        }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text = "Meu Perfil",
            style = MaterialTheme.typography.headlineMedium
        )
        Spacer(
            modifier = Modifier.height(16.dp)
        )

        if (imageUri.isNotBlank()) {

            AsyncImage(
                model = java.io.File(imageUri),
                contentDescription = null,
                modifier = Modifier
                    .size(120.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )

        } else {

            Text(
                text = "📷 Adicione uma foto"
            )
        }

        Spacer(
            modifier = Modifier.height(12.dp)
        )

        Button(
            onClick = {
                launcher.launch("image/*")
            }
        ) {
            Text("Escolher Foto")
        }

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        Card(
            modifier = Modifier.fillMaxWidth()
        ) {

            Column(
                modifier = Modifier.padding(16.dp)
            ) {

                Text(
                    text = usuario?.nome ?: "Carregando...",
                    fontWeight = FontWeight.Bold
                )


                Spacer(
                    modifier = Modifier.height(8.dp)
                )

                Text(
                    text = usuario?.email ?: ""
                )

                Text(
                    text = usuario?.telefone ?: ""
                )
            }
        }

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        Button(
            onClick = {
                navController.navigate(Routes.EDITAR_PERFIL)
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Editar Perfil")
        }

        Spacer(
            modifier = Modifier.height(12.dp)
        )

        Button(
            onClick = {
                mostrarLogout = true
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Sair da Conta")
        }
        if (mostrarLogout) {

            AlertDialog(
                onDismissRequest = {
                    mostrarLogout = false
                },

                title = {
                    Text("Sair da Conta")
                },

                text = {
                    Text("Deseja realmente sair da conta?")
                },

                confirmButton = {
                    TextButton(
                        onClick = {
                            mostrarLogout = false
                            navController.navigate(Routes.LOGIN)
                        }
                    ) {
                        Text("Sair")
                    }
                },

                dismissButton = {
                    TextButton(
                        onClick = {
                            mostrarLogout = false
                        }
                    ) {
                        Text("Cancelar")
                    }
                }
            )
        }
    }
}