/*
Descripción: Pantalla que muestra la lista de contactos, permite eliminarlos y marcarlos como favoritos.
Autor: Anthony Cervantes Cohaila
*/
package com.example.gestorcontactos.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.StarBorder
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.gestorcontactos.Contacto
import androidx.compose.material3.ExperimentalMaterial3Api
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListaScreen(navController: NavHostController) {

    var contactos by remember {
        mutableStateOf(
            listOf(
                Contacto("Anthony Cervantes", "987654321", true),
                Contacto("María López", "912345678", false),
                Contacto("Alex Rhoddo", "965432109", true),
                Contacto("Johan Marquez", "923456789", false)
            )
        )
    }

    val contactosOrdenados = contactos.sortedByDescending { it.favorito }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = {
                navController.navigate("formulario")
            }) {
                Icon(Icons.Default.Add, contentDescription = "Agregar contacto")
            }
        },
        topBar = {
            TopAppBar(title = { Text("Gestor de Contactos") })
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(contactosOrdenados) { contacto ->
                ContactoItem(
                    contacto = contacto,
                    onFavoritoClick = { nuevoEstado ->
                        contactos = contactos.map {
                            if (it.nombre == contacto.nombre) it.copy(favorito = nuevoEstado) else it
                        }
                    },
                    onEliminarClick = {
                        contactos = contactos.filter { it.nombre != contacto.nombre }
                    }
                )
            }
        }
    }
}

@Composable
fun ContactoItem(
    contacto: Contacto,
    onFavoritoClick: (Boolean) -> Unit,
    onEliminarClick: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = contacto.nombre,
                    style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
                )
                Text(
                    text = contacto.telefono,
                    style = MaterialTheme.typography.bodyMedium
                )
            }

            IconButton(onClick = { onFavoritoClick(!contacto.favorito) }) {
                Icon(
                    imageVector = if (contacto.favorito) Icons.Default.Star else Icons.Outlined.StarBorder,
                    contentDescription = "Favorito",
                    tint = if (contacto.favorito) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface
                )
            }

            IconButton(onClick = onEliminarClick) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = "Eliminar",
                    tint = MaterialTheme.colorScheme.error
                )
            }
        }
    }
}