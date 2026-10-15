package com.example.visionapp.ui

import com.example.visionapp.viewmodel.AuthViewModel
import androidx.navigation.NavController
import com.example.visionapp.navigation.Routes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.visionapp.R
import androidx.compose.runtime.rememberCoroutineScope
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.launch


@Composable
fun LoginScreen(
    navController: NavController
) {

    val viewModel: AuthViewModel = viewModel()
    val scope = rememberCoroutineScope()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF149AF5))
    ) {

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.height(70.dp))

            // LOGO
            Image(
                painter = painterResource(id = R.drawable.logo_vision),
                contentDescription = "Logo Vision",
                modifier = Modifier
                    .width(250.dp)
                    .height(120.dp)
            )

            Spacer(modifier = Modifier.height(20.dp))

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp)
                    .weight(1f),
                shape = RoundedCornerShape(40.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                )
            ) {

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(24.dp)
                ) {

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(55.dp)
                            .background(
                                Color(0xFF168AF0),
                                RoundedCornerShape(30.dp)
                            ),
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Button(
                            onClick = {},
                            modifier = Modifier.weight(1f),
                            shape = RoundedCornerShape(30.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.Black
                            )
                        ) {
                            Text("Login")
                        }

                        TextButton(
                            onClick = {
                                navController.navigate(Routes.CADASTRO)
                            },
                            modifier = Modifier.weight(1f)
                        ) {
                            Text(
                                text = "Cadastrar-se",
                                color = Color.White
                            )
                        }

                    }

                    Spacer(modifier = Modifier.height(36.dp))

                    Text(
                        text = "Bem-vindo ao Vision",
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(32.dp))

                    OutlinedTextField(
                        value = viewModel.email,
                        onValueChange = {
                            viewModel.atualizarEmail(it)
                        },
                        label = { Text("E-mail") },
                        modifier = Modifier.fillMaxWidth(),
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Email
                        )
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    OutlinedTextField(
                        value = viewModel.senha,
                        onValueChange = {
                            viewModel.atualizarSenha(it)
                        },
                        label = { Text("Senha") },
                        visualTransformation = PasswordVisualTransformation(),
                        modifier = Modifier.fillMaxWidth()
                    )

                    if (viewModel.mensagemErro.isNotEmpty()) {

                        Text(
                            text = viewModel.mensagemErro,
                            color = Color.Red
                        )

                        Spacer(
                            modifier = Modifier.height(8.dp)
                        )
                    }
                    Spacer(modifier = Modifier.height(40.dp))

                    Button(
                        enabled = !viewModel.carregando,
                        onClick = {

                            scope.launch {

                                try {

                                    val sucesso =
                                        viewModel.login()

                                    if (sucesso) {

                                        navController.navigate(
                                            Routes.HOME
                                        )

                                    }

                                } catch (e: Exception) {

                                    e.printStackTrace()

                                }
                            }
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(55.dp),
                        shape = RoundedCornerShape(30.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFFE67600)
                        )
                    ) {
                        Text(
                            text =
                                if (viewModel.carregando)
                                    "Entrando..."
                                else
                                    "Entrar",
                            color = Color.White,
                            fontWeight = FontWeight.Bold
                        )
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    TextButton(
                        onClick = {
                            navController.navigate(Routes.ESQUECEU_SENHA)
                        },
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    ) {
                        Text(
                            text = "Esqueceu sua senha?",
                            color = Color(0xFFE67600)
                        )
                    }
                }
            }
        }
    }
}