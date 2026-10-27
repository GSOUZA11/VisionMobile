package com.example.visionapp.ui.screens

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.visionapp.R
import com.example.visionapp.navigation.Routes

private val CadastroBlue = Color(0xFF079AF5)
private val CadastroTabBlue = Color(0xFF0788FF)
private val CadastroOrange = Color(0xFFE67600)
private val CadastroGray = Color(0xFF929292)

@Composable
fun CadastroScreen(
    navController: NavController
) {
    var nome by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var senha by remember { mutableStateOf("") }
    var confirmarSenha by remember { mutableStateOf("") }
    var carregando by remember { mutableStateOf(false) }

    val context = LocalContext.current

    BoxWithConstraints(
        modifier = Modifier
            .fillMaxSize()
            .background(CadastroBlue)
    ) {
        val altura = maxHeight

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 30.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(altura * 0.16f))

            Image(
                painter = painterResource(id = R.drawable.logo_vision),
                contentDescription = "Logo Vision",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(140.dp),
                contentScale = androidx.compose.ui.layout.ContentScale.Fit
            )

            Spacer(modifier = Modifier.height(altura * 0.055f))

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                shape = RoundedCornerShape(40.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                )
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 32.dp)
                        .padding(top = 70.dp, bottom = 4.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(59.dp)
                            .background(
                                CadastroTabBlue,
                                RoundedCornerShape(32.dp)
                            ),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .fillMaxHeight()
                                .clickable {
                                    navController.navigate(Routes.LOGIN)
                                },
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "Login",
                                color = Color.White,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }

                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .fillMaxHeight()
                                .background(
                                    Color.Black,
                                    RoundedCornerShape(32.dp)
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "Cadastrar-se",
                                color = Color.White,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(20.dp))

                    Text(
                        text = "Criar Conta",
                        fontSize = 26.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )

                    Spacer(modifier = Modifier.height(18.dp))

                    CadastroInput(
                        value = nome,
                        onValueChange = { nome = it },
                        label = "Nome",
                        keyboardType = KeyboardType.Text
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    CadastroInput(
                        value = email,
                        onValueChange = { email = it },
                        label = "E-mail",
                        keyboardType = KeyboardType.Email
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    CadastroInput(
                        value = senha,
                        onValueChange = { senha = it },
                        label = "Senha:",
                        keyboardType = KeyboardType.Password,
                        isPassword = true
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    CadastroInput(
                        value = confirmarSenha,
                        onValueChange = { confirmarSenha = it },
                        label = "Confirmar:",
                        keyboardType = KeyboardType.Password,
                        isPassword = true
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    Button(
                        onClick = {
                            when {
                                nome.isBlank() ||
                                        email.isBlank() ||
                                        senha.isBlank() ||
                                        confirmarSenha.isBlank() -> {
                                    Toast.makeText(
                                        context,
                                        "Preencha todos os campos.",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }

                                !android.util.Patterns.EMAIL_ADDRESS
                                    .matcher(email.trim())
                                    .matches() -> {
                                    Toast.makeText(
                                        context,
                                        "Digite um e-mail válido.",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }

                                senha.length < 6 -> {
                                    Toast.makeText(
                                        context,
                                        "A senha deve ter pelo menos 6 caracteres.",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }

                                senha != confirmarSenha -> {
                                    Toast.makeText(
                                        context,
                                        "As senhas não coincidem.",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }

                                else -> {
                                    Toast.makeText(
                                        context,
                                        "A integração com a API de cadastro precisa ser conectada.",
                                        Toast.LENGTH_LONG
                                    ).show()
                                }
                            }
                        },
                        enabled = !carregando,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(59.dp),
                        shape = RoundedCornerShape(32.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = CadastroOrange
                        )
                    ) {
                        Text(
                            text = if (carregando) {
                                "Cadastrando..."
                            } else {
                                "Cadastrar-se"
                            },
                            color = Color.White,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }

                    Spacer(modifier = Modifier.height(0.dp))

                    androidx.compose.material3.TextButton(
                        onClick = {
                            navController.navigate(Routes.ESQUECEU_SENHA)
                        },
                        contentPadding = PaddingValues(
                            horizontal = 8.dp,
                            vertical = 2.dp
                        )
                    ) {
                        Text(
                            text = "Esqueceu sua senha?",
                            color = CadastroOrange,
                            fontSize = 14.sp
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(49.dp))
        }
    }
}

@Composable
private fun CadastroInput(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    keyboardType: KeyboardType,
    isPassword: Boolean = false
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
                text = label,
                color = CadastroGray,
                fontSize = 14.sp,
                modifier = Modifier.width(76.dp),
                maxLines = 1
            )

            BasicTextField(
                value = value,
                onValueChange = onValueChange,
                modifier = Modifier.weight(1f),
                singleLine = true,
                textStyle = TextStyle(
                    color = Color.Black,
                    fontSize = 14.sp
                ),
                keyboardOptions = KeyboardOptions(
                    keyboardType = keyboardType
                ),
                visualTransformation = if (isPassword) {
                    PasswordVisualTransformation()
                } else {
                    VisualTransformation.None
                }
            )
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp)
                .height(1.dp)
                .background(CadastroGray)
        )
    }
}
