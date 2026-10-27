package com.example.visionapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.visionapp.R
import com.example.visionapp.navigation.Routes

private val AzulVision = Color(0xFF149AF5)
private val LaranjaVision = Color(0xFFE67600)
private val CinzaTexto = Color(0xFF929292)

@Composable
fun EsqueceuSenhaScreen(
    navController: NavController
) {
    var email by remember { mutableStateOf("") }
    var novaSenha by remember { mutableStateOf("") }
    var confirmarSenha by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(AzulVision)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 34.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(95.dp))

            Image(
                painter = painterResource(id = R.drawable.logo_vision),
                contentDescription = "Logo Vision",
                modifier = Modifier
                    .fillMaxWidth(0.92f)
                    .height(145.dp)
            )

            Spacer(modifier = Modifier.height(20.dp))

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(top = 8.dp, bottom = 8.dp),
                shape = RoundedCornerShape(40.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                )
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 35.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Spacer(modifier = Modifier.height(20.dp))

                    Button(
                        onClick = {},
                        enabled = false,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(58.dp),
                        shape = RoundedCornerShape(30.dp),
                        colors = ButtonDefaults.buttonColors(
                            disabledContainerColor = Color.Black,
                            disabledContentColor = Color.White
                        )
                    ) {
                        Text(
                            text = "Esqueceu sua senha",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }

                    Spacer(modifier = Modifier.height(25.dp))

                    CampoFigma(
                        valor = email,
                        aoAlterar = { email = it },
                        rotulo = "E-mail:",
                        teclado = KeyboardType.Email
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    CampoFigma(
                        valor = novaSenha,
                        aoAlterar = { novaSenha = it },
                        rotulo = "senha nova:",
                        senha = true,
                        teclado = KeyboardType.Password
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    CampoFigma(
                        valor = confirmarSenha,
                        aoAlterar = { confirmarSenha = it },
                        rotulo = "Confirmar senha:",
                        senha = true,
                        teclado = KeyboardType.Password
                    )

                    Spacer(modifier = Modifier.weight(1f))

                    Button(
                        onClick = {
                            // Ação de redefinição será implementada depois.
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(48.dp),
                        shape = RoundedCornerShape(30.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = LaranjaVision
                        )
                    ) {
                        Text(
                            text = "Entrar",
                            color = Color.White,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    TextButton(
                        onClick = {
                            navController.navigate(Routes.CADASTRO)
                        }
                    ) {
                        Text(
                            text = "Não tem conta ainda? Cadastrar-se",
                            color = LaranjaVision,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Normal
                        )
                    }

                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
        }
    }
}

@Composable
private fun CampoFigma(
    valor: String,
    aoAlterar: (String) -> Unit,
    rotulo: String,
    senha: Boolean = false,
    teclado: KeyboardType = KeyboardType.Text
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(34.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = rotulo,
                color = CinzaTexto,
                fontSize = 14.sp,
                maxLines = 1
            )

            Spacer(modifier = Modifier.width(8.dp))

            BasicTextField(
                value = valor,
                onValueChange = aoAlterar,
                singleLine = true,
                modifier = Modifier.weight(1f),
                textStyle = TextStyle(
                    color = Color.Black,
                    fontSize = 14.sp
                ),
                keyboardOptions = KeyboardOptions(
                    keyboardType = teclado
                ),
                visualTransformation = if (senha) {
                    PasswordVisualTransformation()
                } else {
                    androidx.compose.ui.text.input.VisualTransformation.None
                },
                decorationBox = { campo ->
                    Box {
                        campo()
                    }
                }
            )
        }

        HorizontalDivider(
            thickness = 1.dp,
            color = CinzaTexto
        )
    }
}
