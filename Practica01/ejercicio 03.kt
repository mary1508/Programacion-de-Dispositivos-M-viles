/* Descripcion del problema: Realizar una calculadora  básica
suma, resta, multiplicación, división. Debe imprimir
un menú con las opciones incluyendo una opción salir.
Autor: Marycielo Bedoya Pinto
Fecha de creación: 25/08/2024
Fecha de ultima modificación: 25/08/2024 23:21
 */
fun mostrarMenu() {
    while (true) {

        println("==== Menú ====")
        println("1. Suma")
        println("2. Resta")
        println("3. Multiplicación")
        println("4. División")
        println("5. Salir")
        println("Selecciona una opción:")

        //agregando un manejo de error
        val opcion = try {
            readln().toInt()
        } catch (e: NumberFormatException) {
            println("Por favor, ingresa un número válido.")
            continue
        }
        // esto es para ejecutar la opción seleccionada.
        when (opcion) {
            1 -> realizarSuma()
            2 -> realizarResta()
            3 -> realizarMultiplicacion()
            4 -> realizarDivision()
            5 -> {
                println("Saliendo del programa...")
                return
            }
            else -> println("Opción inválida. Por favor, elige una opción válida.")
        }
    }
}
fun realizarSuma() {
    println("Ingresa el primer número:")
    val num1 = readln().toDouble()
    println("Ingresa el segundo número:")
    val num2 = readln().toDouble()

    // Aqui hacemos el calculo de la suma
    val resultado = num1 + num2
    println("Resultado de la suma: $resultado")
}

fun realizarResta() {
    println("Ingresa el primer número:")
    val num1 = readln().toDouble()
    println("Ingresa el segundo número:")
    val num2 = readln().toDouble()
    val resultado = num1 - num2
    println("Resultado de la resta: $resultado")
}
fun realizarMultiplicacion() {
    println("Ingresa el primer número:")
    val num1 = readln().toDouble()
    println("Ingresa el segundo número:")
    val num2 = readln().toDouble()
    val resultado = num1 * num2
    println("Resultado de la multiplicación: $resultado")
}

fun realizarDivision() {
    println("Ingresa el primer número:")
    val num1 = readln().toDouble()
    println("Ingresa el segundo número:")
    val num2 = readln().toDouble()
    if (num2 == 0.0) {
        println("Error: No se puede dividir entre cero.")
    } else {
        val resultado = num1 / num2
        println("Resultado de la división: $resultado")
    }
}

fun main(){
    mostrarMenu()
}
