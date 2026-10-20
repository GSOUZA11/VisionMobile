package com.example.visionapp.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun MenuItem(
    titulo: String,
    icon: ImageVector? = null,
    onClick: () -> Unit = {}
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(vertical = 12.dp)
    ) {

        if (icon != null) {

            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = Color(0xFF149AF5)
            )

            Spacer(
                modifier = Modifier.width(12.dp)
            )
        }

        Text(
            text = titulo,
            color = Color(0xFF149AF5)
        )
    }
}