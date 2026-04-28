/**
 * FormularioScreen.kt
 * Autor: Anthony Cervantes
 */

package com.example.formulariocompose2026_1.ui.screens

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.formulariocompose2026_1.ui.content.FormularioUI

@Composable
fun FormularioScreen() {

    // Estados de los campos de texto
    var nombre    by remember { mutableStateOf("") }
    var edad      by remember { mutableStateOf("") }
    var correo    by remember { mutableStateOf("") }
    var resultado by remember { mutableStateOf("") }

    //  Estados de los nuevos componentes
    var generoSeleccionado by remember { mutableStateOf("") }       // RadioButton
    var aceptaTerminos     by remember { mutableStateOf(false) }    // Checkbox
    var usuarioActivo      by remember { mutableStateOf(false) }    // Switch
    var nivelExperiencia   by remember { mutableFloatStateOf(1f) }  // Slider (1-10)

    // Validaciones
    val errorNombre   = nombre.isBlank()
    val errorEdad     = edad.isBlank() || edad.toIntOrNull() == null
    val errorCorreo   = correo.isBlank() || !correo.contains("@")
    val errorGenero   = generoSeleccionado.isBlank()
    val errorTerminos = !aceptaTerminos

    val formularioValido = !errorNombre && !errorEdad && !errorCorreo &&
            !errorGenero && !errorTerminos

    SideEffect { Log.d("TEST", "RECALCULA") }

    FormularioUI(
        nombre             = nombre,
        edad               = edad,
        correo             = correo,
        resultado          = resultado,
        generoSeleccionado = generoSeleccionado,
        aceptaTerminos     = aceptaTerminos,
        usuarioActivo      = usuarioActivo,
        nivelExperiencia   = nivelExperiencia,
        errorNombre        = errorNombre,
        errorEdad          = errorEdad,
        errorCorreo        = errorCorreo,
        errorGenero        = errorGenero,
        errorTerminos      = errorTerminos,
        formularioValido   = formularioValido,
        onNombreChange     = { nombre = it },
        onEdadChange       = { if (it.all(Char::isDigit)) edad = it },
        onCorreoChange     = { correo = it },
        onGeneroChange     = { generoSeleccionado = it },
        onTerminosChange   = { aceptaTerminos = it },
        onActivoChange     = { usuarioActivo = it },
        onNivelChange      = { nivelExperiencia = it },
        onRegistrar = {
            val estadoUsuario = if (usuarioActivo) "activo" else "inactivo"
            val nivel         = nivelExperiencia.toInt()
            resultado = "Usuario $nombre, $edad años, $estadoUsuario, nivel $nivel"
            Log.d("TEST", "Registrar: $resultado")
        },
        onLimpiar = {
            nombre             = ""
            edad               = ""
            correo             = ""
            resultado          = ""
            generoSeleccionado = ""
            aceptaTerminos     = false
            usuarioActivo      = false
            nivelExperiencia   = 1f
            Log.d("TEST", "Limpiar ejecutado")
        }
    )
}