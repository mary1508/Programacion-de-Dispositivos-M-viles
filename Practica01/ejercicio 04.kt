/* Descripción: Programa que le solicita al usuario que adivine el numero random que
genera la computadora
Autor: Marycielo Bedoya Pinto
Fecha de creación: 25/08/2024
Fecha de ultima modificacion: 25/08/2024
 */
import kotlin.random.Random

fun main(){
    jugar()
}
fun jugar() {
    // genera un número aleatorio entre 1 y 30.
    val numeroSecreto = Random.nextInt(1, 31)
    var intentos = 0
    var adivinado = false

    // Solicita al usuario que adivine el número.
    while (intentos < 5 && !adivinado) {
        println("Adivina el número (entre 1 y 30):")
        val intento = readln().toInt()

        // Se incrementa el contador de intentos.
        intentos++

        // Verificación de la adivinanza.
        if (intento == numeroSecreto) {
            println("¡Felicitaciones! Adivinaste el número.")
            adivinado = true
        } else {
            if (intento > numeroSecreto) {
                println("El número secreto es menor.")
            } else {
                println("El número secreto es mayor.")
            }
        }
    }
    if (!adivinado) {
        println("¡Perdiste! Se acabaron los intentos. El número secreto era $numeroSecreto.")
    }
}
