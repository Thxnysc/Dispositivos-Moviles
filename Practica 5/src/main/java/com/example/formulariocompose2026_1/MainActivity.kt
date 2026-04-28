package com.example.formulariocompose2026_1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.formulariocompose2026_1.ui.screens.FormularioScreen
import com.example.formulariocompose2026_1.ui.theme.FormularioCompose20261Theme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FormularioScreen()
        }
        /*
        setContent {
            FormularioCompose20261Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
        */
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FormularioCompose20261Theme {
        FormularioScreen()
    }
}