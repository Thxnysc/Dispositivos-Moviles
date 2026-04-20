/*
Descripción: Editor de perfil con confirmación - Crear una app que permita
llenar un perfil de usuario, mostrar los datos en otra pantalla y confirmar si está correcto.
Autor: Anthony Cervantes Cohaila
*/

package com.example.editorperfil

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity


class FormularioActivity : AppCompatActivity() {


    private lateinit var etNombre: EditText
    private lateinit var etEdad: EditText
    private lateinit var etCiudad: EditText
    private lateinit var etCorreo: EditText
    private lateinit var btnContinuar: Button

    // Registro para recibir el resultado de otra Activity (ResumenActivity)
    private val resultadoActivity = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        // Se ejecuta cuando la otra Activity retorna un resultado
        if (result.resultCode == RESULT_OK) {
            // Mostrar mensaje de éxito
            android.widget.Toast.makeText(
                this,
                "Perfil guardado correctamente",
                android.widget.Toast.LENGTH_SHORT
            ).show()

            // Limpiar el formulario después de guardar
            limpiarFormulario()
        }
    }

    // Metodo que se ejecuta al crear la Activity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulario)

        // Inicializar componentes de la vista
        inicializarVistas()

        // Restaurar datos si hubo cambio de configuración (ej: rotación)
        restaurarDatos(savedInstanceState)

        // Configurar eventos (botones)
        configurarBotones()
    }

    // Vincula los elementos del XML con el código
    private fun inicializarVistas() {
        etNombre = findViewById(R.id.etNombre)
        etEdad = findViewById(R.id.etEdad)
        etCiudad = findViewById(R.id.etCiudad)
        etCorreo = findViewById(R.id.etCorreo)
        btnContinuar = findViewById(R.id.btnContinuar)
    }

    // Configura el evento click del botón
    private fun configurarBotones() {
        btnContinuar.setOnClickListener {
            // Validar formulario antes de continuar
            if (validarFormulario()) {
                enviarDatosAResumen()
            }
        }
    }

    // Valida que los campos estén completos y correctos
    private fun validarFormulario(): Boolean {
        val nombre = etNombre.text.toString().trim()
        val edad = etEdad.text.toString().trim()
        val ciudad = etCiudad.text.toString().trim()
        val correo = etCorreo.text.toString().trim()

        // Validación del nombre
        if (nombre.isEmpty()) {
            etNombre.error = "Ingrese su nombre"
            return false
        }

        // Validación de la edad
        if (edad.isEmpty()) {
            etEdad.error = "Ingrese su edad"
            return false
        }

        // Validación de la ciudad
        if (ciudad.isEmpty()) {
            etCiudad.error = "Ingrese su ciudad"
            return false
        }

        // Validación del correo (formato válido)
        if (correo.isEmpty() ||
            !android.util.Patterns.EMAIL_ADDRESS.matcher(correo).matches()) {
            etCorreo.error = "Ingrese un correo válido"
            return false
        }

        // si todo esta correcto
        return true
    }

    // Envía los datos a la siguiente Activity (ResumenActivity)
    private fun enviarDatosAResumen() {
        // Crear objeto Usuario con los datos ingresados
        val usuario = Usuario(
            nombre = etNombre.text.toString(),
            edad = etEdad.text.toString(),
            ciudad = etCiudad.text.toString(),
            correo = etCorreo.text.toString()
        )

        // Crear intent para abrir la pantalla de resumen
        val intent = Intent(this, ResumenActivity::class.java).apply {
            putExtra("USUARIO", usuario) // Enviar objeto
        }

        // Lanzar la Activity esperando un resultado
        resultadoActivity.launch(intent)
    }

    // Guarda el estado del formulario (por ejemplo al rotar pantalla)
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putString("NOMBRE", etNombre.text.toString())
        outState.putString("EDAD", etEdad.text.toString())
        outState.putString("CIUDAD", etCiudad.text.toString())
        outState.putString("CORREO", etCorreo.text.toString())
    }

    // Restaura los datos guardados previamente
    private fun restaurarDatos(savedInstanceState: Bundle?) {
        savedInstanceState?.let {
            etNombre.setText(it.getString("NOMBRE", ""))
            etEdad.setText(it.getString("EDAD", ""))
            etCiudad.setText(it.getString("CIUDAD", ""))
            etCorreo.setText(it.getString("CORREO", ""))
        }
    }

    // Limpia todos los campos del formulario
    private fun limpiarFormulario() {
        etNombre.text.clear()
        etEdad.text.clear()
        etCiudad.text.clear()
        etCorreo.text.clear()
    }
}