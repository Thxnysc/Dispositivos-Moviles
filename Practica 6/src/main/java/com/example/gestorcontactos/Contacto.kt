/*
Descripción: Modelo de datos para representar un contacto con nombre,
teléfono y estado de favorito.
Autor: Anthony Cervantes Cohaila
*/
package com.example.gestorcontactos

data class Contacto(
    val nombre: String,
    val telefono: String,
    val favorito: Boolean = false
)