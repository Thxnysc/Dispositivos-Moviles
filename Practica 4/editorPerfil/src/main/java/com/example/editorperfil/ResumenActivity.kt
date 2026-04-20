package com.example.editorperfil


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

// Activity que muestra el resumen del perfil antes de confirmarlo
class ResumenActivity : AppCompatActivity() {

    // Declaración de vistas (TextViews para mostrar datos y botones)
    private lateinit var tvNombre: TextView
    private lateinit var tvEdad: TextView
    private lateinit var tvCiudad: TextView
    private lateinit var tvCorreo: TextView
    private lateinit var btnConfirmar: Button
    private lateinit var btnVolverEditar: Button

    // Objeto que contendrá los datos del usuario recibidos
    private lateinit var usuario: Usuario

    // Metodo que se ejecuta al crear la Activity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resumen)

        // Inicializar componentes de la interfaz
        inicializarVistas()

        // Obtener los datos enviados desde FormularioActivity
        obtenerDatosUsuario()

        // Mostrar los datos en pantalla
        mostrarDatosUsuario()

        // Configurar eventos de los botones
        configurarBotones()
    }

    // Vincula los elementos del XML con el código
    private fun inicializarVistas() {
        tvNombre = findViewById(R.id.tvNombre)
        tvEdad = findViewById(R.id.tvEdad)
        tvCiudad = findViewById(R.id.tvCiudad)
        tvCorreo = findViewById(R.id.tvCorreo)
        btnConfirmar = findViewById(R.id.btnConfirmar)
        btnVolverEditar = findViewById(R.id.btnVolverEditar)
    }

    // Obtiene el objeto Usuario enviado mediante Intent
    private fun obtenerDatosUsuario() {
        usuario = intent.getSerializableExtra("USUARIO") as Usuario
    }

    // Muestra los datos del usuario en los TextView
    private fun mostrarDatosUsuario() {
        tvNombre.text = usuario.nombre
        tvEdad.text = usuario.edad
        tvCiudad.text = usuario.ciudad
        tvCorreo.text = usuario.correo
    }

    // Configura las acciones de los botones
    private fun configurarBotones() {

        // Botón para confirmar el perfil
        btnConfirmar.setOnClickListener {
            confirmarPerfil()
        }

        // Botón para volver a editar los datos
        btnVolverEditar.setOnClickListener {
            volverAEditar()
        }
    }

    // Metodo que se ejecuta al confirmar el perfil
    private fun confirmarPerfil() {
        val resultIntent = Intent().apply {
            // Se envía un mensaje indicando que fue confirmado
            putExtra("RESULTADO", "CONFIRMADO")
        }

        // Se establece el resultado como OK
        setResult(RESULT_OK, resultIntent)

        // Se cierra la Activity y vuelve a la anterior
        finish()
    }

    // Metodo que se ejecuta si el usuario decide editar nuevamente
    private fun volverAEditar() {
        // Se indica que la operación fue cancelada
        setResult(RESULT_CANCELED)

        // Se cierra la Activity
        finish()
    }
}