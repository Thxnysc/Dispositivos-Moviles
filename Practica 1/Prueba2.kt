/*
Descripción: Piedra, Papel, Tijera - Programa para jugar piedra, papel o tijera, el usuario elige una opción y la computadora selecciona una opción aleatoriamente
Autor: Anthony Cervantes
*/

import kotlin.random.Random


fun main(){
    println("Elige una opción: (0 - Piedra), (1 - Papel), (2 - Tijera)")
    val usuario = readln().toInt()

    // La computadora elige de forma aleatoria un número entre 0 y 2
    val pc = Random.nextInt(3)

    // Muestra elección del usuario
    print("Tú elegiste: ")
    when (usuario) {
        0 -> println("Piedra")
        1 -> println("Papel")
        2 -> println("Tijera")
        else -> {
            println("Opción inválida")
            return
        }
    }

    // Muestra elección de la computadora
    print("La computadora eligió: ")
    when (pc) {
        0 -> println("Piedra")
        1 -> println("Papel")
        2 -> println("Tijera")
    }

    // Determina el resultado de la partida
    if(usuario == pc){
        println("Empate")
    } else if (
        (usuario == 0 && pc == 2) || (usuario == 1 && pc == 0 ) || (usuario == 2 && pc == 1)
    ) {
        println("Ganaste!!")
    } else {
        println("Perdiste :(")
    }
}