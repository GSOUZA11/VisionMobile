package com.example.visionapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.visionapp.navigation.AppNavigation
import com.example.visionapp.ui.theme.VisionAppTheme
import com.example.visionapp.utils.AppContext
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.visionapp.utils.ThemeManager

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        AppContext.context = applicationContext
        enableEdgeToEdge()

        setContent {

            val themeManager = ThemeManager(this)

            var temaEscuro by remember {
                mutableStateOf(
                    themeManager.obterTemaEscuro()
                )
            }

            VisionAppTheme(
                darkTheme = temaEscuro
            ) {

                AppNavigation(
                    onThemeChanged = {
                        temaEscuro = it

                        themeManager.salvarTemaEscuro(it)
                    }
                )
            }
        }
    }
}
