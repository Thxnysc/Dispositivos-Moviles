/**
 * Formulario
 * Autor: Anthony Cervantes
 */

package com.example.formulariocompose2026_1.ui.content

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.formulariocompose2026_1.ui.components.CampoTexto

@Composable
fun FormularioUI(
    nombre: String,
    edad: String,
    correo: String,
    resultado: String,
    generoSeleccionado: String,
    aceptaTerminos: Boolean,
    usuarioActivo: Boolean,
    nivelExperiencia: Float,
    errorNombre: Boolean,
    errorEdad: Boolean,
    errorCorreo: Boolean,
    errorGenero: Boolean,
    errorTerminos: Boolean,
    formularioValido: Boolean,
    onNombreChange: (String) -> Unit,
    onEdadChange: (String) -> Unit,
    onCorreoChange: (String) -> Unit,
    onGeneroChange: (String) -> Unit,
    onTerminosChange: (Boolean) -> Unit,
    onActivoChange: (Boolean) -> Unit,
    onNivelChange: (Float) -> Unit,
    onRegistrar: () -> Unit,
    onLimpiar: () -> Unit
) {

    SideEffect {
        Log.d("TEST", "UI Redibujada -> $nombre || $edad || $correo")
    }

    val opciones = listOf("Masculino", "Femenino", "Otro")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {

        Text(
            text = "Registro de Usuario",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp)
        )

        HorizontalDivider()
        Spacer(modifier = Modifier.height(16.dp))

        CampoTexto(nombre, "Nombre *", errorNombre, "El nombre no puede estar vacío", onNombreChange)
        CampoTexto(edad, "Edad *", errorEdad, "Ingresa solo números válidos", onEdadChange)
        CampoTexto(correo, "Correo electrónico *", errorCorreo, "El correo debe contener \"@\"", onCorreoChange)

        Spacer(modifier = Modifier.height(8.dp))
        Text("Género *", style = MaterialTheme.typography.labelLarge, fontWeight = FontWeight.Medium)
        opciones.forEach { opcion ->
            Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()) {
                RadioButton(selected = generoSeleccionado == opcion, onClick = { onGeneroChange(opcion) })
                Text(text = opcion)
            }
        }
        if (errorGenero) {
            Text("Selecciona un género", color = MaterialTheme.colorScheme.error, style = MaterialTheme.typography.labelSmall)
        }

        Spacer(modifier = Modifier.height(16.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Column {
                Text("Estado del usuario", style = MaterialTheme.typography.labelLarge, fontWeight = FontWeight.Medium)
                Text(
                    text = if (usuarioActivo) "Activo" else "Inactivo",
                    style = MaterialTheme.typography.bodySmall,
                    color = if (usuarioActivo) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.outline
                )
            }
            Switch(checked = usuarioActivo, onCheckedChange = onActivoChange)
        }

        Spacer(modifier = Modifier.height(16.dp))
        Text("Nivel de experiencia: ${nivelExperiencia.toInt()}", style = MaterialTheme.typography.labelLarge, fontWeight = FontWeight.Medium)
        Slider(value = nivelExperiencia, onValueChange = onNivelChange, valueRange = 1f..10f, steps = 8, modifier = Modifier.fillMaxWidth())
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text("1 – Básico", style = MaterialTheme.typography.labelSmall)
            Text("10 – Experto", style = MaterialTheme.typography.labelSmall)
        }

        Spacer(modifier = Modifier.height(16.dp))
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()) {
            Checkbox(checked = aceptaTerminos, onCheckedChange = onTerminosChange)
            Spacer(modifier = Modifier.width(4.dp))
            Text("Acepto los términos y condiciones *", style = MaterialTheme.typography.bodyMedium)
        }
        if (errorTerminos) {
            Text(
                "Debes aceptar los términos para continuar",
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.labelSmall,
                modifier = Modifier.padding(start = 48.dp)
            )
        }

        Spacer(modifier = Modifier.height(24.dp))
        Button(onClick = onRegistrar, enabled = formularioValido, modifier = Modifier.fillMaxWidth()) {
            Text("Registrar")
        }
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedButton(onClick = onLimpiar, modifier = Modifier.fillMaxWidth()) {
            Text("Limpiar")
        }

        if (resultado.isNotEmpty()) {
            Spacer(modifier = Modifier.height(20.dp))
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text("✅ Registro exitoso", style = MaterialTheme.typography.titleSmall, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.onPrimaryContainer)
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(resultado, style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onPrimaryContainer)
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))
    }
}