// Descripción: MainActivity con navegación principal del Gestor de Contactos
// Autor: Anthony Cervantes Cohaila

package com.example.gestorcontactos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.gestorcontactos.screens.FormularioScreen
import com.example.gestorcontactos.screens.ListaScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface {
                    val navController = rememberNavController()
                    AppNavigation(navController = navController)
                }
            }
        }
    }
}

@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "lista"
    ) {
        composable("lista") {
            ListaScreen(navController = navController)
        }
        composable("formulario") {
            FormularioScreen(navController = navController)
        }
    }
}