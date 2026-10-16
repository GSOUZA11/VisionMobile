package com.example.visionapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.visionapp.navigation.AppNavigation
import com.example.visionapp.ui.theme.VisionAppTheme
import com.example.visionapp.utils.AppContext

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        AppContext.context = applicationContext
        enableEdgeToEdge()

        setContent {
            VisionAppTheme {
                AppNavigation()
            }
        }
    }
}