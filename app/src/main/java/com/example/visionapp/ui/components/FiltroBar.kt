package com.example.visionapp.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun FiltroBar(
    onFiltroClick: () -> Unit = {},
    onOrdenarClick: () -> Unit = {}
) {

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {

        OutlinedButton(
            onClick = onFiltroClick,
            modifier = Modifier.weight(1f)
        ) {
            Text("Filtros")
        }

        OutlinedButton(
            onClick = onOrdenarClick,
            modifier = Modifier.weight(1f)
        ) {
            Text("Ordenar")
        }
    }
}