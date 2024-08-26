/* Realizar un programa que juegue "piedra, papel o tijera" contra la computadora,
donde esta elige aleatoriamente y el usuario selecciona su opción.
El programa luego imprime si el usuario ganó, perdió o empató.

Autor: Marycielo Bedoya Pinto
Fecha de creación: 24/08/24
Fecha de ultima modificación:*/

import kotlin.random.Random

fun main() {
    // Inicia el juego llamando a la función playGame.
    playGame()
}

fun playGame() {
    // Se obtiene la elección aleatoria de la computadora.
    val computerChoice = getComputerChoice()
    // Se solicita al usuario que ingrese su elección.
    val userChoice = getUserChoice()

    // Se muestra la elección de la computadora y del usuario.
    println("Computer chose: $computerChoice")
    println("You chose: $userChoice")


    determineWinner(computerChoice, userChoice)
}

fun getComputerChoice(): String {
    // Definimos un arreglo con las opciones disponibles.
    val choices = arrayOf("Piedra", "Papel", "Tijera")
    // Seleccionamos una opción aleatoria para la computadora.
    return choices[Random.nextInt(choices.size)]
}

fun getUserChoice(): String {
    // pedimos al usuario que ingrese su elección.
    println("Elige Piedra, Papel o Tijera:")
    // el readln() obtiene la entrada del usuario desde la consola.
    return readln()
}

fun determineWinner(computerChoice: String, userChoice: String) {
    if (computerChoice == userChoice) {
        // Si la elección de la computadora y el usuario es la misma, es un empate.
        println("Empate!")
    } else if ((computerChoice == "Piedra" && userChoice == "Tijera") ||
        (computerChoice == "Tijera" && userChoice == "Papel") ||
        (computerChoice == "Papel" && userChoice == "Piedra")) {
        // Si la elección de la computadora vence a la del usuario según las reglas del juego,
        // entonces la computadora gana y el usuario pierde.
        println("¡Perdiste!")
    } else {
        // En cualquier otro caso, el usuario gana.
        println("¡Ganaste!")
    }
}




