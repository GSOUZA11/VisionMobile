package com.example.visionapp.ui.components

import androidx.compose.material3.AssistChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun CategoriaChip(
    titulo: String,
    onClick: () -> Unit
) {

    AssistChip(
        onClick = onClick,
        label = {
            Text(titulo)
        }
    )
}