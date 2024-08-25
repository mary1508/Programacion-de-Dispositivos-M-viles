/* Realizar un programa que juegue "piedra, papel o tijera" contra la computadora,
donde esta elige aleatoriamente y el usuario selecciona su opción.
El programa luego imprime si el usuario ganó, perdió o empató.

Autor: Marycielo Bedoya Pinto
Fecha de creación: 24/08/24
Fecha de ultima modificación:*/

import kotlin.random.Random

fun main() {
    // aqui iniciams el juego llamando a la función playGame.
    playGame()
}

fun playGame() {
    // obtenemos la elección aleatoria de la computadora.
    val computerChoice = getComputerChoice()
    // solicitamos al usuario que ingrese su elección.
    val userChoice = getUserChoice()

    // Se muestra la elección de la computadora y del usuario.
    println("Computer chose: $computerChoice")
    println("You chose: $userChoice")

    // Se determina el ganador según las reglas del juego.
    determineWinner(computerChoice, userChoice)
}

fun getComputerChoice(): String {
    // definimos un arreglo con las opciones disponibles.
    val choices = arrayOf("Piedra", "Papel", "Tijera")
    // seleccionamos una opción aleatoria para la computadora.
    return choices[Random.nextInt(choices.size)]
}

fun getUserChoice(): String {
    // Se pide al usuario que ingrese su elección.
    println("Elige Piedra, Papel o Tijera:")
    // el readln() obtiene la entrada del usuario desde la consola.
    return readln()
}

fun determineWinner(computerChoice: String, userChoice: String) {
    // Comparación de elecciones para determinar el ganador.
    if (computerChoice == userChoice) {
        println("Empate!")
    } else if ((computerChoice == "Piedra" && userChoice == "Tijera") ||
        (computerChoice == "Tijera" && userChoice == "Papel") ||
        (computerChoice == "Papel" && userChoice == "Piedra")) {

        println("¡Ganaste!")
    } else {
        println("¡Perdiste!")
    }
}



