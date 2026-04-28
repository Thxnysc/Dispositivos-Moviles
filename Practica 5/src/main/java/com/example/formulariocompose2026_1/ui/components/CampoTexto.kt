/**
 * Campo Texto
 * Autor: Anthony Cervantes
 */

package com.example.formulariocompose2026_1.ui.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CampoTexto(
    valor: String,
    label: String,
    esError:Boolean,
    mensajeError: String,
    onValueChange: (String) -> Unit
){

    OutlinedTextField(
        value = valor,
        onValueChange = onValueChange,
        label = { Text(label) },
        isError = esError,
        modifier = Modifier.fillMaxWidth()
    )
    if (esError){
        Text(
            text = mensajeError,
            color = MaterialTheme.colorScheme.error,
            style = MaterialTheme.typography.labelSmall,
        )
    }

    Spacer(modifier=Modifier.height(20.dp))
}