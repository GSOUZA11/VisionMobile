
package com.example.visionapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.material3.TextButton
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
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.visionapp.R
import com.example.visionapp.navigation.Routes
import com.example.visionapp.utils.TokenManager
import com.example.visionapp.viewmodel.AuthViewModel
import kotlinx.coroutines.launch

private val VisionBlue = Color(0xFF079AF5)
private val VisionTabBlue = Color(0xFF0788FF)
private val VisionOrange = Color(0xFFE67600)
private val VisionGray = Color(0xFF929292)

@Composable
fun LoginScreen(
    navController: NavController
) {
    var email by remember { mutableStateOf("") }
    var senha by remember { mutableStateOf("") }

    val viewModel: AuthViewModel = viewModel()
    val scope = rememberCoroutineScope()
    val context = LocalContext.current
    val tokenManager = remember { TokenManager(context) }

    BoxWithConstraints(
        modifier = Modifier
            .fillMaxSize()
            .background(VisionBlue)
    ) {
        val alturaDisponivel = maxHeight

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 30.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(
                modifier = Modifier.height(alturaDisponivel * 0.175f)
            )

            Image(
                painter = painterResource(id = R.drawable.logo_vision),
                contentDescription = "Logo Vision",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(140.dp),
                contentScale = androidx.compose.ui.layout.ContentScale.Fit
            )
            Spacer(modifier = Modifier.height(10.dp))

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
                        .padding(horizontal = 31.dp)
                        .padding(top = 86.dp, bottom = 18.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // Abas Login e Cadastro
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(59.dp)
                            .background(
                                VisionTabBlue,
                                RoundedCornerShape(32.dp)
                            ),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .fillMaxHeight()
                                .background(
                                    Color.Black,
                                    RoundedCornerShape(32.dp)
                                )
                                .clickable { },
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
                                .clickable {
                                    navController.navigate(Routes.CADASTRO)
                                },
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

                    Spacer(modifier = Modifier.height(38.dp))

                    Text(
                        text = "Bem-vindo à o Vision",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        maxLines = 1
                    )

                    Spacer(modifier = Modifier.height(49.dp))

                    // Campo de e-mail com linha inferior
                    VisionInput(
                        value = email,
                        onValueChange = { email = it },
                        label = "E-mail",
                        keyboardType = KeyboardType.Email
                    )

                    Spacer(modifier = Modifier.height(25.dp))

                    // Campo de senha com linha inferior
                    VisionInput(
                        value = senha,
                        onValueChange = { senha = it },
                        label = "senha:",
                        keyboardType = KeyboardType.Password,
                        isPassword = true
                    )

                    Spacer(modifier = Modifier.height(35.dp))

                    Button(
                        onClick = {
                            scope.launch {
                                try {
                                    viewModel.atualizarEmail(email)
                                    viewModel.atualizarSenha(senha)

                                    val sucesso = viewModel.login()

                                    if (sucesso) {
                                        viewModel.loginResponse?.token?.let {
                                            tokenManager.saveToken(it)
                                        }

                                        navController.navigate(Routes.HOME) {
                                            popUpTo(Routes.HOME) {
                                                inclusive = true
                                            }
                                        }
                                    }
                                } catch (e: Exception) {
                                    e.printStackTrace()
                                }
                            }
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(59.dp),
                        shape = RoundedCornerShape(32.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = VisionOrange
                        )
                    ) {
                        Text(
                            text = "Entrar",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    }

                    Spacer(modifier = Modifier.height(14.dp))

                    TextButton(
                        onClick = {
                            navController.navigate(Routes.ESQUECEU_SENHA)
                        },
                        contentPadding = PaddingValues(
                            horizontal = 8.dp,
                            vertical = 4.dp
                        )
                    ) {
                        Text(
                            text = "Esqueceu sua senha?",
                            color = VisionOrange,
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
private fun VisionInput(
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
                .height(38.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = label,
                color = VisionGray,
                fontSize = 14.sp,
                modifier = Modifier.width(63.dp)
            )

            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight(),
                contentAlignment = Alignment.CenterStart
            ) {
                BasicTextField(
                    value = value,
                    onValueChange = onValueChange,
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
                        androidx.compose.ui.text.input.VisualTransformation.None
                    },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp)
                .height(1.dp)
                .background(VisionGray)
        )
    }
}
